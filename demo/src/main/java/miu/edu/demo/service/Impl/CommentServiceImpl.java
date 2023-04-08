package miu.edu.demo.service.Impl;

import miu.edu.demo.domain.Comment;
import miu.edu.demo.domain.Post;
import miu.edu.demo.repository.CommentRepository;
import miu.edu.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public Comment createComment(Comment comment) {
        // Set the Post for the Comment
        Post post = comment.getPost();
        if (post != null) {
            comment.setPost(post);
        }
        return commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(Long id, Comment comment) {
        Comment existingComment = commentRepository.findById(id).orElse(null);
        if (existingComment != null) {
            comment.setId(id);
            return commentRepository.save(comment);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteComment(Long id) {
        Comment existingComment = commentRepository.findById(id).orElse(null);
        if (existingComment != null) {
            commentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

}
