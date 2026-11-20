package service;

import com.plated.project.model.Post;
import com.plated.project.service.PostService;
import org.junit.jupiter.api.Test;
import com.plated.project.repository.PostRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class PostServiceTest {

PostRepository postRepository = mock(PostRepository.class);
    PostService postService = new PostService(postRepository);
    Post post = new Post();

    @Test
    public void toggleLike_shouldFlipLikedAndAdjustCount(){
        post.setLiked(false);
        post.setLikes(5);
        postService.toggleLike(post);
        assertEquals(6, post.getLikes());
        assertTrue(post.isLiked());
        }

}