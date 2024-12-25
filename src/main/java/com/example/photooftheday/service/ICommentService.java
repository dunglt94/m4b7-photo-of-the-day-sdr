package com.example.photooftheday.service;

import com.example.photooftheday.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface ICommentService extends IGeneratedService<Comment>{
    Page<Comment> findAll(Pageable pageable);

    Page<Comment> findByFeedbackDate(LocalDate eventDate, Pageable pageable);
}
