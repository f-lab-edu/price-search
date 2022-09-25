package com.flab.pricesearch.user.repository;

import com.flab.pricesearch.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

  User findByUserId(String userId);


}
