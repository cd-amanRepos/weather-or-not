package com.projectsByAman.weatherUpdates.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TaskBucket {
    @Id
    @GeneratedValue
    private long bucketId;


    @OneToMany(mappedBy = "taskBucket")
    List<Task> tasks = new ArrayList<>();


}
