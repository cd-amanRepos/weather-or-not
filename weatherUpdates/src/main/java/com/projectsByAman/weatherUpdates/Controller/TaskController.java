package com.projectsByAman.weatherUpdates.Controller;

import com.projectsByAman.weatherUpdates.Entity.Task;
import com.projectsByAman.weatherUpdates.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;
/*
    @RequestMapping(value = "/task/{id}", method = RequestMethod.GET)
    public String getTask(@PathVariable("id") long id, Model model) {
        Task task = taskService.getTask(id);
        model.addAttribute("name", task.getName());
        model.addAttribute("destination", task.getDestination());
        return
    }

 */

    // Add bucket id
    @RequestMapping(value = "/task", method = RequestMethod.GET)
    public String getTask(Model model) {
        model.addAttribute("task", new Task());
        return "taskForm";
    }

    @RequestMapping(value = "/task", method = RequestMethod.POST)
    public String createTask(@ModelAttribute("task") Task task, Model model) {
        Task newTask = taskService.createTask(task);
        return "redirect:/dashboard/" + task.getTaskBucket().getBucketId();
    }

    @RequestMapping(value = "/task/{task_id}/{user_id}", method = RequestMethod.DELETE)
    public String deleteTask(@PathVariable("task_id") long task_id,
                             @PathVariable("bucket_id") long bucket_id, Model model) {
            taskService.deleteTask(task_id);
            return "redirect:/dashboard/" + bucket_id;
    }

    @RequestMapping(value = "/task/{bucket_id}",method = RequestMethod.PUT)
    public String updateTask(@ModelAttribute("task") Task task,
                             @PathVariable("bucket_id") long bucket_id, Model model) {
        Task updatedtask = taskService.updateTask(task, bucket_id);
        return "redirect:/dashboard/" + bucket_id;
    }
}
