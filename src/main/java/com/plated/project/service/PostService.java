package com.plated.project.service;

import com.plated.project.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.plated.project.repository.PostRepository;
import java.util.List;

@Service
public class PostService {

private final PostRepository postRepository;

@Autowired
public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void toggleLike(Post post) {
        post.setLiked(!post.isLiked());
        if(post.isLiked()){
            post.setLikes(post.getLikes() +1);
        }
        else{
            post.setLikes(post.getLikes()-1);
        }
    }
 public Post createPost(Post post){
    post.setLikes(0);
    post.setLiked(false);
   return postRepository.save(post);
 }

 public List<Post> getAllPosts(){
    return postRepository.findAll();
 }
public Post findById(long id){
     return  postRepository.findById(id).orElseThrow();
}
public Post save(Post post){
    return postRepository.save(post);
}

}
