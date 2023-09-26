package com.example.SnapChat.Service;

import com.example.SnapChat.Models.Notification;
import com.example.SnapChat.Models.Post;
import com.example.SnapChat.Models.User;
import com.example.SnapChat.Respository.PostRepo;
import com.example.SnapChat.Respository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    PostRepo postRepo;

    public String addUser(User user)
    {
        userRepo.save(user);
        return "User added";

    }

    //Icould have create post service.. and I've done same logic there..

    public String addPost(Integer userId)
    {
       User user= userRepo.findById(userId).get();

       if(user==null)throw new RuntimeException("user Not found");

        Post post=Post.builder()
                .user(user)
                .like(0)
                .build();

        user.getPosts().add(post);

        userRepo.save(user);

        return "Post added successfullY";

    }


    public String likePost(Integer postId)
    {
        Optional<Post> post=postRepo.findById(postId);
        if(post.isPresent()==false)throw new RuntimeException("Post Not found");

        Post myPost=post.get();
        myPost.setLike(myPost.getLike()+1);

        Notification notification=Notification.builder()
                        .post(myPost)
                        .build();
        myPost.getNotifications().add(notification);

        postRepo.save(myPost);

        return "Post Liked Successfully";

    }

    public User findUserWithMostLikes()
    {
        List<User>users=userRepo.findAll();

        User user=null;
        int max=0;
        for(User user1:users)
        {
            int count=0;
            for(Post post: user1.getPosts())
            {
                count+=post.getLike();
            }

            if(count>max){
                max=count;
                user=user1;
            }

        }
        //I can return User Dto to avoid stack overflow..
        return user;

    }
}
