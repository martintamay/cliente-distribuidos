package com.sma.delivery.service.comments;

import com.sma.delivery.beans.comments.CommentsB;
import com.sma.delivery.dto.comments.CommentDTO;
import com.sma.delivery.service.base.IBaseService;


import java.util.List;

public interface ICommentsService extends IBaseService<CommentsB, CommentDTO> {
    public List<CommentsB> getComments();
}
