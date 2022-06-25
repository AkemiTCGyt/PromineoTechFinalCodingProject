package com.promineotech.ddr.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.promineotech.ddr.entity.Comment;
import com.promineotech.ddr.entity.Post;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Service

public class DefaultCommentDao implements CommentDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public Optional<Comment> createComment(Long user_id_fk, Long post_id_fk,
      String comment_body) {
    log.debug("DAO: user_id_fk{}, post_id_fk{}, comment_body{}",
        user_id_fk, post_id_fk, comment_body);
    
    String sql = ""
        + "INSERT INTO comments ("
        + "user_id_fk, post_id_fk, comment_body"
        +") VALUES ("
        +" :user_id_fk, :post_id_fk, :comment_body)";
    
    Map<String, Object> params = new HashMap<>();
    params.put("user_id_fk", user_id_fk);
    params.put("post_id_fk", post_id_fk);
    params.put("comment_body", comment_body);

    jdbcTemplate.update(sql, params);
    return Optional.ofNullable(Comment.builder()
        .user_id_fk(user_id_fk)
        .post_id_fk(post_id_fk)
        .comment_body(comment_body)
        .build());
  }

}
