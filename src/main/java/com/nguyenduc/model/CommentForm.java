package com.nguyenduc.model;

import java.util.Date;

public class CommentForm {
    private Long id;

    private Long vote;

    private String nameViewer;

    private String feedback;

    private Date date;

    public CommentForm() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVote() {
        return vote;
    }

    public void setVote(Long vote) {
        this.vote = vote;
    }

    public String getNameViewer() {
        return nameViewer;
    }

    public void setNameViewer(String nameViewer) {
        this.nameViewer = nameViewer;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
