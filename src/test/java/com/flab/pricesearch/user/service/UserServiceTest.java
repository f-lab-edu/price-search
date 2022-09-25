package com.flab.pricesearch.user.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.flab.pricesearch.constant.Gender;
import com.flab.pricesearch.user.domain.User;
import com.flab.pricesearch.user.dto.UserDto;
import java.time.LocalDate;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class UserServiceTest {

  UserService userService;
  PasswordEncoder passwordEncoder;


  public User createUser() {
    UserDto userDto = new UserDto();
    userDto.setUserId("testID_1");
    userDto.setPassword("1234");
    userDto.setUserName("사용자1");
    userDto.setBirthDate(LocalDate.now());
    userDto.setGender(Gender.MALE);
    userDto.setTel("010-1111-1111");
    userDto.setEmail("abc@naver.com");
    userDto.setEmail("서울시");
    userDto.setTermsAgreeYn(true);
    return User.createUser(userDto, passwordEncoder);
  }

  @Test
  @DisplayName("회원가입 테스트")
  public void saveUserTest(){
    User user = createUser();
    User savedUser = userService.saveUser(user);

    assertThat(user.getUserId()).isEqualTo(savedUser.getUserId());

  }




}