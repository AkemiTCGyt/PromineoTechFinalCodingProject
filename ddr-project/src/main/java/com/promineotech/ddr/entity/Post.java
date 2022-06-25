package com.promineotech.ddr.entity;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
  private long post_id_pk;
  private long user_id_fk;
  private long ddr_song_id_fk;
  private String post_body;
  private String time_of_post;
  

}
