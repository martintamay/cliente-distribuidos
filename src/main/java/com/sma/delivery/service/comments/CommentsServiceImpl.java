package com.sma.delivery.service.comments;

import com.sma.delivery.beans.comments.CommentsB;
import com.sma.delivery.dto.comments.CommentsDTO;
import com.sma.delivery.dto.comments.CommentsResult;
import com.sma.delivery.service.base.BaseServiceImpl;
import com.sma.delivery.service.establishments.IEstablishmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sma.delivery.rest.comments.ICommentsResource;
import com.sma.delivery.rest.establishments.IEstablishmentsResource;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("commentsService")
public class CommentsServiceImpl extends BaseServiceImpl<CommentsB, CommentsDTO> implements ICommentsService {

    @Autowired
    private ICommentsResource _commentsResource;
    @Autowired
    private IEstablishmentsService _establishmentsResource;
    public CommentsServiceImpl() {
    }

    @Override
    public CommentsB save(CommentsB bean) {
        final CommentsDTO comments = convertBeanToDto(bean);
        final CommentsDTO dto = _commentsResource.save(comments);
        final CommentsB commentsB = convertDtoToBean(dto);
        return commentsB;
    }

    @Override
    public void delete(Integer id){
        _commentsResource.delete(id);
    }

    @Override
    public List<CommentsB> getAll(Integer page) {
        final CommentsResult result = _commentsResource.getAll(page);
        final List<CommentsDTO> cList = null == result.getComments() ? new ArrayList<CommentsDTO>()
                : result.getComments();

        final List<CommentsB> comments = new ArrayList<CommentsB>();
        for (CommentsDTO dto : cList) {
            final CommentsB bean = convertDtoToBean(dto);
            comments.add(bean);
        }
        return comments;
    }

    @Override
    public CommentsB getById(Integer id) {
        final CommentsDTO dto = _commentsResource.getById(id);
        final CommentsB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
    public List<CommentsB> find(String text) {

        final CommentsResult result = _commentsResource.find(text);
        final List<CommentsDTO> cList = null == result.getComments() ? new ArrayList<CommentsDTO>()
                : result.getComments();

        final List<CommentsB> comments = new ArrayList<CommentsB>();
        for (CommentsDTO dto : cList) {
            final CommentsB bean = convertDtoToBean(dto);
            comments.add(bean);
        }
        return comments;
    }

    @Override
    protected CommentsB convertDtoToBean(CommentsDTO dto) {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("content", dto.get_content());
        params.put("title", dto.get_title());
        params.put("deleted", String.valueOf(dto.get_deleted()));
        final CommentsB commentsB = new CommentsB(params);
        commentsB.set_establishments(_establishmentsResource.getById(dto.get_establishments_id()));
        return commentsB;
    }

    @Override
    protected CommentsDTO convertBeanToDto(CommentsB bean) {
        final CommentsDTO dto = new CommentsDTO();
        dto.setId(bean.getId());
        dto.set_content(bean.getContent());
        dto.set_title(bean.getTitle());
        dto.set_deleted(bean.getDeleted());
        dto.set_establishments_id(bean.get_establishments().getId());


        return dto;
    }
}
