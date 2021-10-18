package com.nguyenduc.service.comment;

import com.nguyenduc.model.Comment;
import com.nguyenduc.service.IGeneralService;

import java.util.List;

public interface ICommentService extends IGeneralService<Comment> {
    List<Comment> findByVote(Long vote);
}
