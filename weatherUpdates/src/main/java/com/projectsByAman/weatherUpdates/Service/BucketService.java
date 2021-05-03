package com.projectsByAman.weatherUpdates.Service;

import com.projectsByAman.weatherUpdates.Entity.Task;
import com.projectsByAman.weatherUpdates.Entity.TaskBucket;
import com.projectsByAman.weatherUpdates.Repository.TaskBucketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BucketService {
    @Autowired
    private TaskBucketRepository taskBucketRepository;


    public List<Task> getDashboard(long bucket_id) {
        Optional<TaskBucket> bucket = taskBucketRepository.findById(bucket_id);
        return bucket.get().getTasks();
    }

    public TaskBucket createDashboard() {
        TaskBucket bucket = new TaskBucket();
        return taskBucketRepository.save(bucket);
    }
}
