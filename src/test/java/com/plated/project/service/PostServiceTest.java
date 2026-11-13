package com.plated.project.service;

import com.plated.project.model.Post;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostServiceTest {

    @Test
    void toggleLikeShouldMarkLikedAndAddOneWhenPostIsNotLiked() {
        Post post = new Post();
        post.setLiked(false);
        post.setLikes(5);
        PostService postService = new PostService(null);
        postService.toggleLike(post);
        assertTrue(post.isLiked());
        assertEquals(6, post.getLikes());
    }
    @Test
    void toggleLikeShouldMarkUnlikedAndRemoveOneWhenPostIsLiked() {
        Post post = new Post();
        post.setLiked(true);
        post.setLikes(5);
        PostService postService = new PostService(null);
        postService.toggleLike(post);
        assertFalse(post.isLiked());
        assertEquals(4, post.getLikes());
    }
@Test
    void toggleLikeTwiceShouldReturnPostToOriginalState(){
        Post post = new Post();
        post.setLiked(false);
        post.setLikes(5);
        PostService postService = new PostService(null);
        postService.toggleLike(post);
    postService.toggleLike(post);
        assertFalse(post.isLiked());
        assertEquals(5, post.getLikes());

}

}