package com.example.SnapChat.Controllers;

import com.example.SnapChat.Models.User;
import com.example.SnapChat.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    UserService userService;
    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody User user)
    {
        return new ResponseEntity(userService.addUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/add-post")
    public  ResponseEntity addPost(@RequestParam("userId") Integer userId)
    {
        return new ResponseEntity(userService.addPost(userId),HttpStatus.CREATED);
    }


    @PutMapping("/like-post")
    public ResponseEntity likePost(@RequestParam("postId") Integer postId)
    {
        return new ResponseEntity(userService.likePost(postId),HttpStatus.CREATED);
    }

    //GET API - Find the user who got most overall likes over all posts

    @GetMapping("/findUserWithMostLikes")
    public   ResponseEntity getUserWithMostLikes()
    {
        User user=userService.findUserWithMostLikes();
        return new ResponseEntity(user,HttpStatus.ACCEPTED);
    }
}
