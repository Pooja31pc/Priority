package com.test.priority.model;

public class AddAreaAdmin {

    private Long id;
    private String priorityName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPriorityName() {
        return priorityName;
    }

    public void setPriorityName(String priorityName) {
        this.priorityName = priorityName;
    }

    public AddAreaAdmin() {
    }

    public AddAreaAdmin(Long id, String priorityName) {
        this.id = id;
        this.priorityName = priorityName;
    }

    public AddAreaAdmin(String priorityName) {
        this.priorityName = priorityName;
    }

}
