package com.projectsByAman.weatherUpdates.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue
    private long userId;
    private String username;
    private String email;

    @OneToOne
    @JoinColumn(name = "bucket_id")
    private TaskBucket bucket;

}
