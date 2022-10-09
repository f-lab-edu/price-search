package com.flab.pricesearch.user.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.flab.pricesearch.user.constant.Gender;
import com.flab.pricesearch.user.domain.User;
import com.flab.pricesearch.user.dto.UserDto;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired
    UserService userService;
    @Autowired
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
    public void saveUserTest() {
        User user = createUser();
        User savedUser = userService.saveUser(user);

        assertThat(user.getUserId()).isEqualTo(savedUser.getUserId());
    }

    @Test
    @DisplayName("중복 회원 가입 테스트")
    public void saveDuplicateUserTest() {
        User user1 = createUser();
        User user2 = createUser();
        userService.saveUser(user1);
        Throwable e = assertThrows(IllegalStateException.class, () -> {
            userService.saveUser(user2);});
        assertEquals("이미 가입된 회원 입니다.", e.getMessage());
    }
}