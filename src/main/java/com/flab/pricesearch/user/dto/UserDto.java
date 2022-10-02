package com.flab.pricesearch.user.dto;

import com.flab.pricesearch.user.constant.Gender;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    @NotBlank(message = "id는 필수 입력값 입니다.")
    private String userId;

    @NotBlank(message = "비밀번호는 필수 입력값 입니다.")
    private String password;

    @NotBlank(message = "이름 필수 입력값 입니다.")
    private String userName;

    @NotBlank(message = "생년월일은 필수 입력값 입니다.")
    private LocalDate birthDate;

    @NotBlank(message = "성별은 필수 입력값 입니다.")
    private Gender gender;

    @NotBlank(message = "전화번호는 필수 입력값 입니다.")
    private String tel;

    @NotBlank(message = "이메일 주소는 필수 입력값 입니다.")
    private String email;

    @NotBlank(message = "주소는 필수 입력값 입니다.")
    private String address;

    @NotBlank(message = "약관 동의를 진행해 주세요.")
    private Boolean termsAgreeYn;


}
