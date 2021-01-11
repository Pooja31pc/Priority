package com.test.priority.controller;

import com.test.priority.model.AddAreaAdmin;
import com.test.priority.model.PriorityArea;
import com.test.priority.repository.AreasRepository;
import com.test.priority.repository.UserPreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AreasRepository areasRepo;

    @Autowired
    private UserPreferenceRepository userPreferenceRepo;

    @GetMapping("areas")
    public List<PriorityArea> getAreas()
    {
        List<PriorityArea> areas = (List<PriorityArea>) areasRepo.findAll();

        return areas;
    }


    @PostMapping("addareas")
    public String postAreas(@RequestBody AddAreaAdmin addAreaAdmin){

            PriorityArea priorityArea = new PriorityArea(addAreaAdmin.getPriorityName());
            areasRepo.save(priorityArea);
            return "Success";

    }

}
