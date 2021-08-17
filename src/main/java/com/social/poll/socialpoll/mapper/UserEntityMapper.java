package com.social.poll.socialpoll.mapper;


import com.social.poll.socialpoll.dto.UserDto;
import com.social.poll.socialpoll.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper extends EntityMapper<UserDto, User> {
}
