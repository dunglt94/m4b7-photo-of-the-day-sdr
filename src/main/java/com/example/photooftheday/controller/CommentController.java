package com.example.photooftheday.controller;

import com.example.photooftheday.model.Comment;
import com.example.photooftheday.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/photo-of-the-day")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @GetMapping
    public String showIndex(
            @PageableDefault(size = 5) Pageable pageable,
            ModelMap model) {
        Page<Comment> comments = commentService.findByEventDate(LocalDate.now(), pageable);
        model.addAttribute("comments", comments);
        model.addAttribute("comment", new Comment());
        return "index";
    }

    @PostMapping("/comment")
    public String addComment(Comment comment) {
        commentService.save(comment);
        return "redirect:/photo-of-the-day";
    }

    @GetMapping("/{id}/like")
    public String likeComment(@PathVariable Long id) {
        Optional<Comment> comment = commentService.findById(id);
        if (comment.isPresent()) {
            Comment likeComment = comment.get();
            int likes = likeComment.getLikes();
            likeComment.setLikes(likes + 1);
            commentService.save(likeComment);
        }
        return "redirect:/photo-of-the-day";
    }
}
