package com.example.photooftheday.service;

import com.example.photooftheday.exception.BadWordsException;
import com.example.photooftheday.model.Comment;
import com.example.photooftheday.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CommentService implements ICommentService {
    private final static String[] BAD_WORD = {"ugly", "trash"};

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
    public Page<Comment> findByFeedbackDate(LocalDate eventDate, Pageable pageable) {
        return commentRepository.findByFeedbackDate(eventDate, pageable);
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public void save(Comment comment) throws BadWordsException {
        if (isContainBadWord(comment)) {
            throw new BadWordsException();
        }
            commentRepository.save(comment);
    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }

    private boolean isContainBadWord(Comment comment) {
        boolean containBadWord = false;
        for (String badWord : BAD_WORD) {
            if (comment.getFeedback().toLowerCase().contains(badWord.toLowerCase())) {
                containBadWord = true;
                break;
            }
        }
        return containBadWord;
    }
}
