package com.flab.pricesearch.user.service;

import com.flab.pricesearch.user.domain.User;
import com.flab.pricesearch.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(User user) {
        validateDuplicationUser(user);
        return userRepository.save(user);
    }

    private void validateDuplicationUser(User user) {
        User findUser = userRepository.findByUserId(user.getUserId());
        if (findUser != null) {
            throw new IllegalStateException("이미 가입된 회원 입니다.");
        }
    }
}

