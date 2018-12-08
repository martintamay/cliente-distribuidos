package com.sma.delivery.rest.comments;

import com.sma.delivery.dto.comments.CommentsDTO;
import com.sma.delivery.dto.comments.CommentsResult;
import com.sma.delivery.rest.base.IBaseResource;

public interface ICommentsResource extends IBaseResource<CommentsDTO> {

    public CommentsResult getAll(Integer page);
    public CommentsResult find(String text);
    public CommentsResult getComments();


}