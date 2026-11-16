package com.plated.project.service;

import com.plated.project.model.Comment;
import com.plated.project.model.Post;
import com.plated.project.repository.CommentRepository;
import com.plated.project.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public Comment addCommentToPost(Long postId, Comment comment) {
        Post found = postRepository.findById(postId)
                .orElseThrow();
        comment.setPost(found);
        return  commentRepository.save(comment);
    }


    public List<Comment> getComments(Long postId){
      Post found =  postRepository.findById(postId)
              .orElseThrow();
       return commentRepository.findByPost(found);
    }
}
