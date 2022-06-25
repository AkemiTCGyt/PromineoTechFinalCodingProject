package com.promineotech.ddr.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.ddr.entity.Post;
import com.promineotech.ddr.service.PostService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultPostController implements PostController {
  
  @Autowired
  private PostService postService;
  
  @Override
  public Optional<Post> createPost(Long user_id_fk, Long ddr_song_id_fk, String post_body){
    
    return postService.createPost(user_id_fk, ddr_song_id_fk, post_body);
  }

}
