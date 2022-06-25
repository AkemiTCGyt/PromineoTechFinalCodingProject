package com.promineotech.ddr.service;

import java.util.Optional;
import com.promineotech.ddr.entity.Comment;

public interface CommentService {
  
  /**
   * Creates a Post with the user inputed information
   * @param comment_id_pk
   * @param user_id_fk
   * @param post_id_fk
   * @param post_body
   * @return
   */
  Optional<Comment> createComment(Long user_id_fk, Long post_id_fk, String comment_body);

}
