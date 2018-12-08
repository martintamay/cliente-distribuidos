package com.sma.delivery.service.comments;

import com.sma.delivery.beans.comments.CommentsB;
import com.sma.delivery.dto.comments.CommentsDTO;
import com.sma.delivery.service.base.IBaseService;

import java.util.List;

public interface ICommentsService extends IBaseService<CommentsB, CommentsDTO> {
    public List<CommentsB> getComments();
}
