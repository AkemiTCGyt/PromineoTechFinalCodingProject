package com.promineotech.ddr.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.ddr.entity.User;
import com.promineotech.ddr.service.UserService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultUserController implements UserController{
  
  @Autowired
  private UserService userService;
  
  @Override
  public Optional<User> createUser(String username){
    
    return userService.createUser(username);
  }

}
