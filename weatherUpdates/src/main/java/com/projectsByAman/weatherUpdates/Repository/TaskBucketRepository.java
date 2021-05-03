package com.projectsByAman.weatherUpdates.Repository;

import com.projectsByAman.weatherUpdates.Entity.TaskBucket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskBucketRepository extends JpaRepository<TaskBucket, Long> {
}
