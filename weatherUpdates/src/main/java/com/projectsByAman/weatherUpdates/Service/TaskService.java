package com.projectsByAman.weatherUpdates.Service;

import com.projectsByAman.weatherUpdates.Entity.Task;
import com.projectsByAman.weatherUpdates.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;


    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(long task_id) {
        Task task = taskRepository.findById(task_id).get();
        taskRepository.delete(task);
    }

    public Task updateTask(Task task, long bucket_id) {
        Task originalTask = taskRepository.findById(task.getTaskId()).get();
        originalTask.setDescription(task.getDescription());
        originalTask.setName(task.getName());
        originalTask.setDateAndTimeToReach(task.getDateAndTimeToReach());
        originalTask.setDestination(task.getDestination());
        originalTask.setStartLocation(task.getStartLocation());

        return taskRepository.save(originalTask);
    }
}
