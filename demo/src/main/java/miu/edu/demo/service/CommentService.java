package miu.edu.demo.service;

import miu.edu.demo.domain.Comment;

import java.util.List;

public interface CommentService {
    Comment getCommentById(Long id);
    Comment createComment(Comment comment);
    Comment updateComment(Long id, Comment comment);
    boolean deleteComment(Long id);
    List<Comment> getCommentsByPostId(Long postId);

}

