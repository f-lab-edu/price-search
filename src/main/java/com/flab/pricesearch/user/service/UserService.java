package com.flab.pricesearch.user.service;


import com.flab.pricesearch.exception.user.DuplicatedIdException;
import com.flab.pricesearch.user.domain.SpringSecurityUser;
import com.flab.pricesearch.user.domain.User;
import com.flab.pricesearch.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public User saveUser(User user) {
        validateDuplicationUser(user);
        return userRepository.save(user);
    }

    private void validateDuplicationUser(User user) {
        User findUser = userRepository.findByUserId(user.getUserId());
        if (findUser != null) {
            throw new DuplicatedIdException("이미 가입된 회원 입니다.");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = userRepository.findByUserId(userId);

        if (user == null) {
            throw new UsernameNotFoundException(userId);
        }

        return SpringSecurityUser.builder()
            .username(user.getUserId())
            .password(user.getPassword())
            .roles(user.getRoleType().toString())
            .build();
    }
}

