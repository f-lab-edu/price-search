package com.flab.pricesearch.user.domain;

import com.flab.pricesearch.user.constant.Gender;
import com.flab.pricesearch.user.constant.PlatformType;
import com.flab.pricesearch.user.constant.RoleType;
import com.flab.pricesearch.user.constant.UserStatus;
import com.flab.pricesearch.user.dto.UserDto;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Getter
@Setter
@ToString
public class User {

    @Id
    private String userId;                    // 사용자 ID

    private String password;                  // 비밀번호

    @Enumerated(EnumType.STRING)
    private PlatformType platformType;        // 플랫폼 타입 (Email, NAVER, KAKAO)

    private String token;                     // 토큰

    @Enumerated(EnumType.STRING)
    private RoleType roleType;                // 역할 타입 (사용자, 관리자)

    private String userName;                  // 이름

    private LocalDate birthDate;              // 생년월일

    @Enumerated(EnumType.STRING)
    private Gender gender;                    // 성별

    private String tel;                       // 전화번호

    private String email;                     // 이메일

    private String address;                   // 주소

    private LocalDateTime registrationDate;   // 가입일

    private Boolean termsAgreeYn;              // 약관 동의 여부

    private LocalDateTime termsAgreeDate;     // 약관 동의 일시

    private LocalDateTime dormantDate;        // 휴면 일시

    private LocalDateTime withdrawalDate;     // 탙퇴일시

    private UserStatus userStatus;            // 상태 정상(NORMAL), 휴면(DORMANT), 탈퇴(WITHDRAWAL)

    private LocalDateTime lastUpdateDate;     // 마지막 수정일

    /**
     * User Entity 생성.
     */
    public static User createUser(UserDto userDto, PasswordEncoder passwordEncoder) {
        User user = new User();
        user.setUserId(userDto.getUserId());
        String password = passwordEncoder.encode(userDto.getPassword());
        user.setPassword(password);
        user.setRoleType(RoleType.USER);
        user.setUserName(userDto.getUserName());
        user.setBirthDate(userDto.getBirthDate());
        user.setGender(userDto.getGender());
        user.setTel(userDto.getTel());
        user.setEmail(userDto.getEmail());
        user.setEmail(userDto.getAddress());
        user.setRegistrationDate(LocalDateTime.now());
        user.setTermsAgreeYn(userDto.getTermsAgreeYn());
        user.setTermsAgreeDate(LocalDateTime.now());
        user.setDormantDate(null);
        user.setWithdrawalDate(null);
        user.setUserStatus(UserStatus.NORMAL);
        user.setLastUpdateDate(LocalDateTime.now());
        return user;
    }

}
