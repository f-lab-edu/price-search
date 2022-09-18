package com.flab.pricesearch.user.domain.service;

import com.flab.pricesearch.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class UserServiceTest {

  @Autowired
  UserService userService;


}