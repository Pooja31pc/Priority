package com.test.priority.model;

import java.util.ArrayList;

public class AddUserPreference {

    private Long userId;
    private ArrayList<AreaReview> areas;

  //  {"areas":[{"area":"nam","ranking":1,"rating":6},{{"area":"nam","ranking":{}}}],"user":""}


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public ArrayList<AreaReview> getAreas() {
        return areas;
    }

    public void setAreas(ArrayList<AreaReview> areas) {
        this.areas = areas;
    }

    public AddUserPreference(Long userId, ArrayList<AreaReview> areas) {
        this.userId = userId;
        this.areas = areas;
    }

    public AddUserPreference() {
    }

}
