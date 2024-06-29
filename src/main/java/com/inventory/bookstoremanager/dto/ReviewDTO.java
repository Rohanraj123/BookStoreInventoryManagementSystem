package com.inventory.bookstoremanager.dto;

import java.util.Date;

public class ReviewDTO {
    private Long id;
    private String reviewerName;
    private String comment;
    private double rating;
    private Date date;

    public ReviewDTO() {}
    public ReviewDTO(Long id, String reviewerName, String comment, double rating,
                     Date date) {
        this.id = id;
        this.reviewerName = reviewerName;
        this.comment = comment;
        this.rating = rating;
        this.date = date;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getReviewerName() { return reviewerName; }
    public void setReviewerName(String reviewerName) { this.reviewerName = reviewerName; }
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    @Override
    public String toString() {
        return "ReviewDTO{" +
                "id=" + id +
                ", reviewerName=" + reviewerName + '\'' +
                ", comment=" + comment + '\'' +
                ", rating=" + rating +
                ", date=" + date +
                "}";
    }
}