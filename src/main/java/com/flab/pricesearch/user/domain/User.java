package com.flab.pricesearch.user.domain;

import lombok.Data;

@Data
public class User {
  private String userId;
  private String password;
  private String platformType;
  private String token;
  private String userName;
  private String birthDate;
  private String gender;
  private String tel;
  private String email;
  private String address;
  private String regDate;
  private String termsAgreeYn;
  private String termsAgreeDateTime;
  private String dormantYn;
  private String dormantDate;
  private String withdrawalDate;
  private String status;
  private String lastUpdateDate;
}
