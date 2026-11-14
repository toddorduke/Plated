package com.plated.project.service;

import com.plated.project.model.Post;
import com.plated.project.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.data.util.Pair.of;

@ExtendWith(MockitoExtension.class)
public class PostServiceMockTest {

@Mock
    PostRepository postRepository;

@InjectMocks
    PostService postService;

    Post post = new Post();

 @Test
    void createPostShouldResetLikedAndLikesAndSaveOnce(){
     post.setLiked(true);
     post.setLikes(10);
     when(postRepository.save(post))
             .thenReturn(post);
             Post result = postService.createPost(post);
             assertFalse(result.isLiked());
             assertEquals(0,result.getLikes());
             verify(postRepository).save(post);
 }

 @Test
    void getAllPostsShouldReturnAllPostsFromRepository(){
     Post post1 = new Post();
     Post post2 = new Post();
     List<Post> posts =  List.of(post1, post2);
     when(postRepository.findAll())
             .thenReturn(posts);
     List<Post> result = postService.getAllPosts();
     assertEquals(posts, result);
 }

 @Test
    void findByIdShouldReturnPostWhenItExists(){
     Post post = new Post();
     Optional<Post> found = Optional.of(post);
     when(postRepository.findById(5L))
             .thenReturn(found);
     Post result = postService.findById(5);
     assertEquals(post, result);
     verify(postRepository).findById(5L);

 }
}
