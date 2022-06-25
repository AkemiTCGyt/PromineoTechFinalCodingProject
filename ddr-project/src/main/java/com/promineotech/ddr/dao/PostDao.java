package com.promineotech.ddr.dao;

import java.util.List;
import java.util.Optional;
import com.promineotech.ddr.entity.Post;

public interface PostDao {
  
  //Method to create a post to a corresponding ddr_song_id_fk and user_id_fk
  Optional<Post> createPost(Long user_id_fk, Long ddr_song_id_fk, String post_body);

}
