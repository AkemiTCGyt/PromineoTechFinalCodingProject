package com.promineotech.ddr.service;

import java.util.List;
import com.promineotech.ddr.entity.Post;
import java.util.Optional;

public interface PostService {
  
  /**
   * Creates a Post with the user inputed information
   * @param post_id_pk
   * @param user_id_fk
   * @param ddr_song_id_fk
   * @param post_body
   * @return
   */
  Optional<Post> createPost(Long user_id_fk, Long ddr_song_id_fk, String post_body);

}
