package com.plated.project.controller;

import com.plated.project.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.plated.project.service.PostService;

import java.util.List;


@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPost(){
        return postService.getAllPosts();
    }
    @PostMapping
    public Post createPost(@RequestBody Post post){
       return postService.createPost(post);
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable long id){
        return postService.findById(id);
    }

    @PutMapping ("/{id}/like")
    public Post toggleLike(@PathVariable long id){
     Post post = postService.findById(id);
     postService.toggleLike(post);
    return postService.save(post);

    }
}
