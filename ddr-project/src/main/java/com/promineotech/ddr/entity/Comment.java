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
public class Comment {
  private long comment_id_pk;
  private long user_id_fk;
  private long post_id_fk;
  private String comment_body;
  private String time_of_comment;
}
