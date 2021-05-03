package com.projectsByAman.weatherUpdates.Controller;

import com.projectsByAman.weatherUpdates.Entity.Task;
import com.projectsByAman.weatherUpdates.Entity.TaskBucket;
import com.projectsByAman.weatherUpdates.Service.BucketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BucketController {
    @Autowired
    private BucketService bucketService;
/*
    @RequestMapping(value = "/dashboard", method = RequestMethod.POST)
    public TaskBucket assignDashboard(long user_id) {
        return bucketService.createDashboad();
    }
    */

    @RequestMapping(value = "/dashboard/{bucket_id}", method = RequestMethod.GET)
    public String getDashboad(@PathVariable("bucket_id") long bucket_id, Model model) {
        List<Task> tasks = bucketService.getDashboard(bucket_id);
        model.addAttribute("tasks", tasks);
        return "dashboard";
    }
}
