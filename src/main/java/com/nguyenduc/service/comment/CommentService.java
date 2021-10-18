package com.nguyenduc.service.comment;

import com.nguyenduc.model.Comment;
import com.nguyenduc.repository.comment.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService{
    @Autowired
    private ICommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void delete(Long id) {
        commentRepository.delete(id);
    }

    @Override
    public List<Comment> findByName(String name) {
        return null;
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public List<Comment> findByVote(Long vote) {
        return commentRepository.findByVote(vote);
    }
}
