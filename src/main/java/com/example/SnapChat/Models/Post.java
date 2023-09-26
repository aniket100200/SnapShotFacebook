package com.example.SnapChat.Models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int postId;
    Time  time;


    //
    @ManyToOne
    @JoinColumn
    User user;

    int like;

    @OneToMany(mappedBy = "post")
    List<Notification>notifications=new ArrayList<>();


}
