package com.plated.project.repository;

import com.plated.project.model.Comment;
import com.plated.project.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

     List<Comment> findByPost(Post post);


}
