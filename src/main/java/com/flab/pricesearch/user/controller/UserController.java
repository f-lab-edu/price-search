package com.flab.pricesearch.user.controller;

import com.flab.pricesearch.user.domain.User;
import com.flab.pricesearch.user.dto.UserDto;
import com.flab.pricesearch.user.service.UserService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users")
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping(value = "/signUp")
    public String signUpForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "/user/signUpForm";
    }

    @PostMapping(value = "/signUp")
    public String newUser(@Valid UserDto userDto, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "/user/signUpForm";
        }

        try {
            User user = User.createUser(userDto, passwordEncoder);
            userService.saveUser(user);
        } catch (IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "/user/signUpForm";
        }

        return "redirect:/";
    }

    @GetMapping(value = "/login")
    public String loginUser() {
        return "/user/loginForm";
    }

    @GetMapping(value = "/login/error")
    public String loginError(Model model) {
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요");
        return "/user/loginForm";
    }


}
