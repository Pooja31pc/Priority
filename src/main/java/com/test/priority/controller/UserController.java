package com.test.priority.controller;

import com.test.priority.model.AddUserPreference;
import com.test.priority.model.AreaReview;
import com.test.priority.model.PriorityArea;
import com.test.priority.model.UserPreference;
import com.test.priority.repository.AreasRepository;
import com.test.priority.repository.UserPreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AreasRepository areasRepo;

    @Autowired
    private UserPreferenceRepository userPreferenceRepo;

    @GetMapping("areas")
    public List<PriorityArea> getAreas() {
        List<PriorityArea> areas = (List<PriorityArea>) areasRepo.findAll();

        return areas;
    }
    @PostMapping("adduserpreference")
    public String postUserPrefer(@RequestBody AddUserPreference addUserPreference) {
        ArrayList<AreaReview> areaReviews = addUserPreference.getAreas();
        for (AreaReview review : areaReviews) {
            String priorityName = review.getPriorityAreaName();
            List<PriorityArea> areas = areasRepo.findByName(priorityName);
            if (areas.size() == 1) {
                PriorityArea area = areas.get(0);
                UserPreference userPreference = new UserPreference(addUserPreference.getUserId(), review.getRating(), review.getRank(), area);
                userPreferenceRepo.save(userPreference);
            }
        }
        return "Success";
    }
}


