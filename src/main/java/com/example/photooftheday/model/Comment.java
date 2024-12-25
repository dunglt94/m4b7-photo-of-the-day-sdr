package com.example.photooftheday.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int point;

    private String author;

    @Column(columnDefinition = "TEXT")
    private String feedback;

    private int likes;

    private LocalDate feedbackDate;

    private LocalDateTime feedbackDateTime;

    public Comment() {
        this.feedbackDate = LocalDate.now();
        this.feedbackDateTime = LocalDateTime.now();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public LocalDate getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(LocalDate feedbackDate) {
        this.feedbackDate = feedbackDate;
    }

    public LocalDateTime getFeedbackDateTime() {
        return feedbackDateTime;
    }

    public void setFeedbackDateTime(LocalDateTime feedbackDateTime) {
        this.feedbackDateTime = feedbackDateTime;
    }

}
