package com.plated.project.controller;

import com.plated.project.model.Post;
import com.plated.project.service.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;


import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PostController.class)
public class PostControllerTest {


    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    PostService postService;

    Post post1;
    Post post2;
    List<Post> posts;

    @BeforeEach
    void setUp() {
        post1 = new Post();
        post2 = new Post();
        posts = List.of(post1, post2);
    }

    @Test
    void getAllPostsShouldReturnOkAndListOfPosts() throws Exception {
        when(postService.getAllPosts()).thenReturn(posts);
        mockMvc.perform(get("/api/posts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
        verify(postService).getAllPosts();
    }

    @Test
    void findByIdShouldReturnOkAndThePost() throws Exception {
        when(postService.findById(5L)).thenReturn(post1);
        post1.setId(5L);
        mockMvc.perform(get("/api/posts/5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(5));
        verify(postService).findById(5L);
    }

    @Test
    void createPostShouldReturnOkAndTheSavedPost() throws Exception {
        post1.setDish("pizza");
        String json = "{\"dish\": \"pizza\"}";
        when(postService.createPost(any(Post.class))).thenReturn(post1);
        mockMvc.perform(post("/api/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.dish").value("pizza"));
        verify(postService).createPost(any(Post.class));
    }

    @Test
    void toggleLikeShouldReturnOkAndTheSavedPost() throws Exception {
        post1.setId(5L);
        when(postService.findById(5L))
                .thenReturn(post1);
        when(postService.save(post1))
                .thenReturn(post1);
        mockMvc.perform(put("/api/posts/5/like"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(5));
        verify(postService).findById(5L);
        verify(postService).toggleLike(any(Post.class));
        verify(postService).save(post1);
    }
}
