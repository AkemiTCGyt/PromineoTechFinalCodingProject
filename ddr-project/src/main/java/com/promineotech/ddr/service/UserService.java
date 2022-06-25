package com.promineotech.ddr.service;

import java.util.Optional;
import com.promineotech.ddr.entity.User;

public interface UserService {
  
  /**
   * Creates a user with the provided username
   * @param username
   * @return
   */
  Optional<User> createUser(String username);

}
