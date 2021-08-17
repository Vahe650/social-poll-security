package com.social.poll.socialpoll.service.impl;


import com.social.poll.socialpoll.dto.UserDto;
import com.social.poll.socialpoll.entity.User;
import com.social.poll.socialpoll.mapper.UserEntityMapper;
import com.social.poll.socialpoll.repo.UserRepository;
import com.social.poll.socialpoll.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService {

    private  final UserEntityMapper userEntityMapper;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserEntityMapper userEntityMapper, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userEntityMapper = userEntityMapper;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    void init() {
        try {
            findByUsername("admin");
        } catch (EntityNotFoundException e) {
            User user = new User();
            user.setUsername("admin");
            user.setPassword(passwordEncoder.encode("admin"));
            user.setUserType(User.UserType.ADMIN);
            userRepository.save(user);
        }
    }

    @Override
    public UserDto findByUsername(String username) {
        return userEntityMapper.toDto(userRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new));
    }
}

