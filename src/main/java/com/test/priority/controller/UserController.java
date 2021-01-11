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
import java.util.HashSet;
import java.util.List;

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
        long totalAreas = areasRepo.count();
        HashSet<Long> ranksAvailable = new HashSet<>();
        for (long i=1;i<=totalAreas;i++)
            ranksAvailable.add(i);
        for (AreaReview review : areaReviews) {
            String priorityName = review.getPriorityAreaName();
            List<PriorityArea> areas = areasRepo.findByName(priorityName);
            if (areas.size() == 1) {
                PriorityArea area = areas.get(0);
                if (review.getRating()<=5 && review.getRating()>0) {
                    if (ranksAvailable.contains((long)review.getRank())) {
                        UserPreference userPreference = new UserPreference(addUserPreference.getUserId(), review.getRating(), review.getRank(), area);
                        userPreferenceRepo.save(userPreference);
                        ranksAvailable.remove((long)review.getRank());
                    }else if(review.getRank()>totalAreas){
                        return "Error: Priority area ranking exceeded the limit.";
                    } else return "error: Same ranking allotted to more than one priority area.";
                }else return "Error: Rating exceeded the limit.";
            } else return "Mentioned priority area not present.";
        }
        return "Success";
    }
}
