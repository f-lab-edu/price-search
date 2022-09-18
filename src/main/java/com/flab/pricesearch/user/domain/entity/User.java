package com.flab.pricesearch.user.domain.entity;

import lombok.Data;

import javax.persistence.Id;

@Data
public class User {

  @Id
  private String userId;             // 사용자 ID
  private String password;           // 비밀번호
  private String platformType;       // 플랫폼 타입 (Naver, Kakao)
  private String token;              // 토큰
  private String userName;           // 이름
  private String birthDate;          // 생년월일
  private String gender;             // 성별
  private String tel;                // 전화번호
  private String email;              // 이메일
  private String address;            // 주소
  private String registrationDate;   // 가입일
  private String termsAgreeYn;       // 약관 동의 여부
  private String termsAgreeDateTime; // 약관 동의 일시
  private String dormantYn;          // 휴면 여부
  private String dormantDate;        // 휴면 일시
  private String withdrawalDate;     // 탙퇴일
  private String status;             // 상태 준회원(N), 정회원(Y), 탈퇴(D)
  private String lastUpdateDate;     // 마지막 수정일
}
