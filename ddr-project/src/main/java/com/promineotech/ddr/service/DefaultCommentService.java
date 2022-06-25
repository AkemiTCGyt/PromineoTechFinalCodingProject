package com.promineotech.ddr.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.ddr.dao.DefaultCommentDao;
import com.promineotech.ddr.entity.Comment;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultCommentService implements CommentService {
  
  @Autowired
  private DefaultCommentDao commentDao;

  @Override
  public Optional<Comment> createComment(Long user_id_fk, Long post_id_fk,
      String comment_body) {
    return commentDao.createComment(user_id_fk, post_id_fk, comment_body);
  }

}
