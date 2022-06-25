package com.promineotech.ddr.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.promineotech.ddr.entity.User;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Service

public class DefaultUserDao implements UserDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  // POST method to create a new user in the users table
  
  @Override
  public Optional<User> createUser(String username){
    log.debug("DAO: username{}", username);
    
    String sql = ""
        + "INSERT INTO users ("
        + "username"
        +") VALUES ("
        +" :username)";
    
    Map<String, Object> params = new HashMap<>();
    params.put("username", username);

    jdbcTemplate.update(sql, params);
    return Optional.ofNullable(User.builder()
        .username(username)
        .build());
  }

}
