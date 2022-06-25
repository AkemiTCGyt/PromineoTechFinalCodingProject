package com.promineotech.ddr.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import com.promineotech.ddr.dao.DefaultUserDao;
import com.promineotech.ddr.entity.User;

@Service
@Slf4j
public class DefaultUserService implements UserService {
  
  @Autowired
  private DefaultUserDao userDao;

  @Override
  public Optional<User> createUser(String username) {
    return userDao.createUser(username);
  }

}
