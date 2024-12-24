package com.example.photooftheday.repository;

import com.example.photooftheday.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ICommentRepository extends PagingAndSortingRepository<Comment, Long> {
    Page<Comment> findAll(Pageable pageable);

    Page<Comment> findByEventDate(LocalDate eventDate, Pageable pageable);
}
