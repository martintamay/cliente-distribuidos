package com.sma.delivery.rest.comments;

import com.sma.delivery.dto.comments.CommentsDTO;
import com.sma.delivery.dto.comments.CommentsResult;
import com.sma.delivery.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

@Repository("commentsResource")
public class CommentsResourceImpl extends BaseResourceImpl<CommentsDTO> implements ICommentsResource {

    public CommentsResourceImpl() {
        super(CommentsDTO.class, "/comments");
    }

    @Override
    public CommentsResult getAll(Integer page) {
        final CommentsResult result = getWebResource().path("/"+page+"/"+20).get(CommentsResult.class);
        return result;
    }

    @Override
    public CommentsDTO getById(Integer id) {
        return getWebResource().path("/" + id).get(getDtoClass());
    }

    @Override
    public CommentsResult find(String text) {
        final CommentsResult result = getWebResource().path("/buscar").queryParam("text", text).get(CommentsResult.class);
        return result;
    }

    @Override
    public CommentsResult getComments() {
        return getWebResource().path("/" + 1 + "/" + 200).get(CommentsResult.class);

    }

}
