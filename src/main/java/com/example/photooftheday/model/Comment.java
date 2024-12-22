package com.example.photooftheday.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int point;

    private String author;

    @Column(columnDefinition = "TEXT")
    private String feedback;

    private int likes;

    @DateTimeFormat(pattern = "yyyy-MM-đ")
    private LocalDate eventDate;

    public Comment() {
        this.eventDate = LocalDate.now();
    }

    public Comment(int id, int point, String author, String feedback, int likes) {
        this.id = id;
        this.point = point;
        this.author = author;
        this.feedback = feedback;
        this.likes = likes;
        this.eventDate = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }
}
