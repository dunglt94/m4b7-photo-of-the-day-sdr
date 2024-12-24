package com.example.photooftheday.service;

import com.example.photooftheday.model.Comment;
import com.example.photooftheday.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService implements ICommentService {
    @Autowired
    private ICommentRepository commentRepository;

    @Override
    public Iterable<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Page<Comment> findAll(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }

    @Override
    public Page<Comment> findByEventDate(LocalDate eventDate, Pageable pageable) {
        return commentRepository.findByEventDate(eventDate, pageable);
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public void save(Comment object) {
        commentRepository.save(object);
    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }
}
