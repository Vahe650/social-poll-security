package com.social.poll.socialpoll.mapper;



import com.social.poll.socialpoll.dto.AnswerDto;
import com.social.poll.socialpoll.entity.Answer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswerEntityMapper extends EntityMapper<AnswerDto, Answer> {
}
