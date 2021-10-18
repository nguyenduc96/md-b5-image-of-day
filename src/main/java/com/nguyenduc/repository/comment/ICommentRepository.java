package com.nguyenduc.repository.comment;

import com.nguyenduc.model.Comment;
import com.nguyenduc.repository.IGeneralRepository;

import java.util.List;

public interface ICommentRepository extends IGeneralRepository<Comment> {
    List<Comment> findByVote(Long vote);
}
