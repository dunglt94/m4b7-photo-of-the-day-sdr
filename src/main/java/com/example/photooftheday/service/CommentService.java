package com.example.photooftheday.service;

import com.example.photooftheday.model.Comment;
import com.example.photooftheday.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService {
    @Autowired
    private ICommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(int id) {
        return commentRepository.findById(id);
    }

    @Override
    public void save(Comment object) {
        commentRepository.save(object);
    }

    @Override
    public void delete(int id) {
        commentRepository.delete(id);
    }
}
