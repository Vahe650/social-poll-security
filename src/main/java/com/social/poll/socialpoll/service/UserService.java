package com.social.poll.socialpoll.service;

import com.social.poll.socialpoll.dto.UserDto;

public interface UserService {

    UserDto findByUsername(String username);
}

