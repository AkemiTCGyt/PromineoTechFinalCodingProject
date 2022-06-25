package com.promineotech.ddr.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.ddr.dao.DefaultPostDao;
import com.promineotech.ddr.entity.Post;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultPostService implements PostService {
  
  @Autowired
  private DefaultPostDao postDao;

  @Override
  public Optional<Post> createPost(Long user_id_fk, Long ddr_song_id_fk, String post_body) {
    return postDao.createPost(user_id_fk, ddr_song_id_fk, post_body);
  }

}
