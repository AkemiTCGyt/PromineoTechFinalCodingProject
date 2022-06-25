package com.promineotech.ddr.dao;

import java.util.Optional;
import com.promineotech.ddr.entity.User;

public interface UserDao {

  //Method to create a new user
  Optional<User> createUser(String username);
}
