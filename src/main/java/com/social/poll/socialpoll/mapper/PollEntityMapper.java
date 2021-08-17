package com.social.poll.socialpoll.mapper;


import com.social.poll.socialpoll.dto.PollDto;
import com.social.poll.socialpoll.entity.Poll;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PollEntityMapper extends EntityMapper<PollDto, Poll> {
}
