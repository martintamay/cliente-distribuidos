package com.sma.delivery.rest.comments;

import com.sma.delivery.dto.comments.CommentDTO;
import com.sma.delivery.dto.comments.CommentResult;
import com.sma.delivery.rest.base.IBaseResource;

public interface ICommentsResource extends IBaseResource<CommentDTO> {

    public CommentResult find(String text, Integer page);
    public CommentResult getAll(Integer page);
    public CommentResult getComments();


}