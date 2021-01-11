package com.test.priority.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="tbl_areas")
public class PriorityArea {

    @Id
    @Column(name="priority_name", unique=true)
    private String priorityName;

//    @OneToMany(cascade=CascadeType.ALL, mappedBy="priorityArea")
//    private Set<UserPreference> userPreference;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="priorityArea")
    private Set<UserPreference> userPreference;



    public String getPriorityName() {

        return priorityName;
    }

    public void setPriorityName(String priorityName) {

        this.priorityName = priorityName;
    }


    public PriorityArea() {
    }

    public PriorityArea(String priorityName) {

        this.priorityName = priorityName;
    }

}
