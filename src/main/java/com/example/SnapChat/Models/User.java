package com.example.SnapChat.Models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userId;

    String name;

    int age;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Post>posts=new ArrayList<>();

}
