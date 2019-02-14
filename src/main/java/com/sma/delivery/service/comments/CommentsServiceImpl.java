package com.sma.delivery.service.comments;

import com.sma.delivery.beans.comments.CommentsB;
import com.sma.delivery.dto.comments.CommentDTO;
import com.sma.delivery.dto.comments.CommentResult;
import com.sma.delivery.service.base.BaseServiceImpl;
import com.sma.delivery.service.establishments.IEstablishmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.sma.delivery.rest.comments.ICommentsResource;
import com.sma.delivery.service.user.IUserService;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("commentsService")
public class CommentsServiceImpl extends BaseServiceImpl<CommentsB, CommentDTO> implements ICommentsService {

    @Autowired
    private ICommentsResource _commentsResource;
    @Autowired
    private IEstablishmentsService _establishmentsService;
    @Autowired
    private IUserService _userService;
    public CommentsServiceImpl() {
    }

    @Override
    @CachePut(value="delivery-cacheC", key= "'commentsClients_'+#comment.id", condition = "#bean.id!=null")
    public CommentsB save(CommentsB bean)  {
        final CommentDTO comments = convertBeanToDto(bean);
        final CommentDTO dto = _commentsResource.save(comments);

        final CommentsB commentsB = convertDtoToBean(dto);
        if (bean.getId() == null) {
            getCacheManager().getCache("delivery-cacheC").put("commentsClients_" + dto.getId(), commentsB);
        }
        return commentsB;
    }

    @Override
    @CacheEvict(value = "delivery-cacheC", key = "'commentsClients_' + #id")
    public void delete(Integer id){
        _commentsResource.delete(id);
    }

    @Override
    public List<CommentsB> getAll(Integer page)  {
        final CommentResult result = _commentsResource.getAll(page);
        final List<CommentDTO> cList = null == result.getComments() ? new ArrayList<CommentDTO>()
                : result.getComments();

        final List<CommentsB> comments = new ArrayList<CommentsB>();
        for (CommentDTO dto : cList) {
            final CommentsB bean = convertDtoToBean(dto);
            comments.add(bean);
            if (bean.getId() != null) {
                getCacheManager().getCache("delivery-cacheC").put("commentsClients_" + dto.getId(), bean);
            }
        }
        return comments;
    }

    @Override
    @Cacheable(value= "delivery-cacheC", key= "'commentsClients_'+#id")
    public CommentsB getById(Integer id)  {
        final CommentDTO dto = _commentsResource.getById(id);
        final CommentsB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
    public List<CommentsB> find(String text, Integer page)  {

        final CommentResult result = _commentsResource.find(text, page);
        final List<CommentDTO> cList = null == result.getComments() ? new ArrayList<CommentDTO>()
                : result.getComments();

        final List<CommentsB> comments = new ArrayList<CommentsB>();
        for (CommentDTO dto : cList) {
            final CommentsB bean = convertDtoToBean(dto);
            comments.add(bean);
            if (bean.getId() != null) {
                getCacheManager().getCache("delivery-cacheC").put("commentsClients_" + dto.getId(), bean);
            }
        }
        return comments;
    }

    @Override
    protected CommentsB convertDtoToBean(CommentDTO dto)  {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("content", dto.getContent());
        params.put("title", dto.getTitle());
        params.put("deleted", String.valueOf(dto.getDeleted()));
        final CommentsB commentsB = new CommentsB(params);
        commentsB.set_user(_userService.getById(dto.getUserId()));
        commentsB.set_establishments(_establishmentsService.getById(dto.getEstablishmentId()));
        return commentsB;
    }

    @Override
    protected CommentDTO convertBeanToDto(CommentsB bean) {
        final CommentDTO dto = new CommentDTO();
        dto.setId(bean.getId());
        dto.setContent(bean.getContent());
        dto.setTitle(bean.getTitle());
        dto.setDeleted(bean.getDeleted());
        dto.setEstablishmentId(bean.get_establishments().getId());
        dto.setUserId(bean.get_user().getId());
        return dto;
    }

    @Override
    public List<CommentsB> getComments()  {
        final CommentResult result = _commentsResource.getComments();
        final List<CommentDTO> cList = null == result.getComments() ? new ArrayList<CommentDTO>() : result.getComments();
        final List<CommentsB> comments = new ArrayList<CommentsB>();
        for (CommentDTO dto : cList) {
            comments.add(convertDtoToBean(dto));
        }
        return comments;
    }
}
