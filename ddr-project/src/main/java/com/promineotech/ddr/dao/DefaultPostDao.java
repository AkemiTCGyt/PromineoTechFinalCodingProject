package com.promineotech.ddr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.promineotech.ddr.entity.DDRSong;
import com.promineotech.ddr.entity.Post;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Service

public class DefaultPostDao implements PostDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  // POST method to create a new post in the posts table
  
  @Override
  public Optional<Post> createPost(Long user_id_fk, Long ddr_song_id_fk,
      String post_body){
    log.debug("DAO: ddr_song_id_fk{}, post_body{}",
        ddr_song_id_fk, post_body);
    
    String sql = ""
        + "INSERT INTO posts ("
        + "user_id_fk, ddr_song_id_fk, post_body"
        +") VALUES ("
        +" :user_id_fk, :ddr_song_id_fk, :post_body)";
    
    Map<String, Object> params = new HashMap<>();
    params.put("user_id_fk", user_id_fk);
    params.put("ddr_song_id_fk", ddr_song_id_fk);
    params.put("post_body", post_body);

    jdbcTemplate.update(sql, params);
    return Optional.ofNullable(Post.builder()
        .user_id_fk(user_id_fk)
        .ddr_song_id_fk(ddr_song_id_fk)
        .post_body(post_body)
        .build());
  }

}
