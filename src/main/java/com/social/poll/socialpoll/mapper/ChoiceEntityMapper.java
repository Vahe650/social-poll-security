package com.social.poll.socialpoll.mapper;


import com.social.poll.socialpoll.dto.ChoiceDto;
import com.social.poll.socialpoll.entity.Choice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChoiceEntityMapper extends EntityMapper<ChoiceDto, Choice> {
}
