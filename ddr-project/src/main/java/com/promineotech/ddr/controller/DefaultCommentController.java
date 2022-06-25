package com.promineotech.ddr.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.ddr.entity.Comment;
import com.promineotech.ddr.entity.Post;
import com.promineotech.ddr.service.CommentService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultCommentController implements CommentController {
  
  @Autowired
  private CommentService commentService;
  
  @Override
  public Optional<Comment> createComment(Long user_id_fk, Long post_id_fk, String comment_body){
    
    return commentService.createComment(user_id_fk, post_id_fk, comment_body);
  }

}
