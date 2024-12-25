package com.example.photooftheday.aspect;

import com.example.photooftheday.exception.BadWordsException;
import com.example.photooftheday.model.Comment;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BadWordFeedBackLogger {
    @AfterThrowing(pointcut = "execution(* com.example.photooftheday.service.CommentService.save(..))", throwing = "e")
    public void printLog(JoinPoint joinPoint, BadWordsException e) {
        Object[] args = joinPoint.getArgs();
        Comment comment = (Comment) args[0];
        System.out.println("Bad word detected!");
        System.out.println("Author: " + comment.getAuthor());
        System.out.println("Feedback: " + comment.getFeedback());
        System.out.println("Date and time of feedback: "
                + comment.getFeedbackDate() + " "
                + comment.getFeedbackDateTime().toLocalTime());
    }
}
