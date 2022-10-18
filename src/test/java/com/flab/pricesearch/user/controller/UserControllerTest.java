package com.flab.pricesearch.user.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;

import com.flab.pricesearch.user.constant.Gender;
import com.flab.pricesearch.user.domain.User;
import com.flab.pricesearch.user.dto.UserDto;
import com.flab.pricesearch.user.service.UserService;
import java.time.LocalDate;
import javax.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class UserControllerTest {

    @Autowired
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User createUser(String userId, String password) {
        UserDto userDto = new UserDto();

        userDto.setUserId(userId);
        userDto.setPassword(password);
        userDto.setUserName("사용자1");
        userDto.setBirthDate(LocalDate.now());
        userDto.setGender(Gender.MALE);
        userDto.setTel("010-1111-1111");
        userDto.setEmail("abc@naver.com");
        userDto.setEmail("서울시");
        userDto.setTermsAgreeYn(true);
        User user = User.createUser(userDto, passwordEncoder);
        return userService.saveUser(user);
    }

    @Test
    @DisplayName("로그인 성공 테스트")
    public void loginSuccessTest() throws Exception {
        String userId = "testID_1";
        String password = "1234";
        this.createUser(userId, password);
        mockMvc.perform(formLogin().userParameter("userId")
                .loginProcessingUrl("/users/login")
                .user(userId).password(password))
            .andExpect(SecurityMockMvcResultMatchers.authenticated());
    }

    @Test
    @DisplayName("로그인 실패 테스트")
    public void loginFailTest() throws Exception {
        String email = "testID_1";
        String password = "1234";
        this.createUser(email, password);
        mockMvc.perform(formLogin().userParameter("userId")
                .loginProcessingUrl("/users/login")
                .user(email).password("12345"))
            .andExpect(SecurityMockMvcResultMatchers.unauthenticated());
    }


}