package com.projectsByAman.weatherUpdates.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Task {
    @Id
    @GeneratedValue
    private long taskId;
    private String name;
    private String description;
    private String startLocation;
    private String destination;

    @JsonFormat(pattern = "dd-mm-yyyy HH:mm:ss")
    private Date dateAndTimeToReach;

    @ManyToOne
    @JoinColumn(name = "bucket_id")
    @JsonBackReference
    private TaskBucket taskBucket;

}
