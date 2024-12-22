package com.example.photooftheday.controller;

import com.example.photooftheday.model.Comment;
import com.example.photooftheday.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/photo-of-the-day")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @GetMapping
    public String showIndex(ModelMap model) {
        List<Comment> todayComments = getComments();
        model.addAttribute("comments", todayComments);
        model.addAttribute("comment", new Comment());
        return "index";
    }

    private List<Comment> getComments() {
        List<Comment> comments = commentService.findAll();
        List<Comment> todayComments = new ArrayList<>();
        LocalDate today = LocalDate.now();
        for (Comment comment : comments) {
            if (comment.getEventDate().isEqual(today)) {
                todayComments.add(comment);
            }
        }
        return todayComments;
    }

    @PostMapping("/comment")
    public String addComment(Comment comment) {
        commentService.save(comment);
        return "redirect:/photo-of-the-day";
    }

    @GetMapping("/{id}/like")
    public String likeComment(@PathVariable int id) {
        Comment comment = commentService.findById(id);
        int likes = comment.getLikes();
        comment.setLikes(likes + 1);
        commentService.save(comment);
        return "redirect:/photo-of-the-day";
    }
}
