package com.test.priority.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name="user_preference")
public class UserPreference {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long entry_id;
    private Long user_id;

    @Column(name="area_rating")
    private int areaRating;

    @Column(name="area_ranking")
    private int areaRanking;

//    @ManyToOne
//    @JoinColumn(name="area_name", nullable=false)
//    private PriorityArea priorityArea;

    @ManyToOne
    @JoinColumn(name="area_name", nullable=false)
    private PriorityArea priorityArea;

    public Long getEntry_id() {
        return entry_id;
    }

    public void setEntry_id(Long entry_id) {
        this.entry_id = entry_id;
    }

    public PriorityArea getPriorityArea() {
        return priorityArea;
    }

    public void setPriorityArea(PriorityArea priorityArea) {
        this.priorityArea = priorityArea;
    }

    public Long getUser_id() {

        return user_id;
    }

    public void setUser_id(Long user_id) {

        this.user_id = user_id;
    }

    public int getAreaRating() {

        return areaRating;
    }

    public void setAreaRating(int areaRating) {

        this.areaRating = areaRating;
    }

    public int getAreaRanking() {

        return areaRanking;
    }

    public void setAreaRanking(int areaRanking) {

        this.areaRanking = areaRanking;
    }

    public PriorityArea getAreas() {

        return priorityArea;
    }

    public void setAreas(PriorityArea priorityArea) {

        this.priorityArea = priorityArea;
    }

    public UserPreference() {
    }

    public UserPreference(Long entry_id, Long user_id, int areaRating, int areaRanking, PriorityArea priorityArea) {
        this.entry_id = entry_id;
        this.user_id = user_id;
        this.areaRating = areaRating;
        this.areaRanking = areaRanking;
        this.priorityArea = priorityArea;
    }

    public UserPreference(Long user_id, int areaRating, int areaRanking, PriorityArea priorityArea) {
        this.user_id = user_id;
        this.areaRating = areaRating;
        this.areaRanking = areaRanking;
        this.priorityArea = priorityArea;
    }
}
