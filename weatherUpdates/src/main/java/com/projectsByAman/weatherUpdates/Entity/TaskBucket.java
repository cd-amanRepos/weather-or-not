package com.projectsByAman.weatherUpdates.Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TaskBucket {
    @Id
    @GeneratedValue
    private long bucketId;


    @OneToMany(mappedBy = "taskBucket")
    List<Task> tasks = new ArrayList<>();


}
