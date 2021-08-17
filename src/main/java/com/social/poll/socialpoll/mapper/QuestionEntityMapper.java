package com.social.poll.socialpoll.mapper;


import com.social.poll.socialpoll.dto.QuestionDto;
import com.social.poll.socialpoll.entity.Question;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionEntityMapper extends EntityMapper<QuestionDto, Question> {
}
