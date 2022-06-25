package com.promineotech.ddr.dao;

import java.util.Optional;
import com.promineotech.ddr.entity.Comment;

public interface CommentDao {
  
  //Method to create a comment to a corresponding post
  Optional<Comment> createComment(Long user_id_fk, Long post_id_fk, String comment_body);

}