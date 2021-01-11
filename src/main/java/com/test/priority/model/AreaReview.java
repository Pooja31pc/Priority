package com.test.priority.model;

public class AreaReview {

    private String priorityAreaName;
    private int rank;
    private int rating;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRating() {
        return rating;
    }

    public String getPriorityAreaName() {
        return priorityAreaName;
    }

    public void setPriorityAreaName(String priorityAreaName) {
        this.priorityAreaName = priorityAreaName;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public AreaReview(String priorityAreaName, int rank, int rating) {
        this.priorityAreaName = priorityAreaName;
        this.rank = rank;
        this.rating = rating;
    }

    public AreaReview() {
    }

}
