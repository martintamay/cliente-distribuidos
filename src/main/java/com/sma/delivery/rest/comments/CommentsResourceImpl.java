package com.sma.delivery.rest.comments;

import com.sma.delivery.dto.comments.CommentDTO;
import com.sma.delivery.dto.comments.CommentResult;
import com.sma.delivery.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

@Repository("commentsResource")
public class CommentsResourceImpl extends BaseResourceImpl<CommentDTO> implements ICommentsResource {

    public CommentsResourceImpl() {
        super(CommentDTO.class, "/comments");
    }

    @Override
    public CommentResult getAll(Integer page) {
        final CommentResult result = getWebResource().path("/"+page+"/"+20).get(CommentResult.class);
        return result;
    }

    @Override
    public CommentDTO getById(Integer id) {
        return getWebResource().path("/" + id).get(getDtoClass());
    }

    @Override
    public CommentResult find(String text, Integer page) {
        final CommentResult result = getWebResource().path("/search/"+page+"/"+3+"/"+text).get(CommentResult.class);
        return result;
    }

    @Override
    public CommentResult getComments() {
        return getWebResource().path("/" + 1 + "/" + 200).get(CommentResult.class);

    }

}
