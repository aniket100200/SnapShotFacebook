package com.example.SnapChat.Models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Notification
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int noteId;

    @ManyToOne
    @JoinColumn
    Post post;

    Time time;

}
