package com.social.poll.socialpoll.service;


import com.social.poll.socialpoll.dto.QuestionChoiceDto;
import com.social.poll.socialpoll.dto.QuestionDto;

import java.util.List;

public interface QuestionSerivce {

    List<QuestionDto> findAll();

    QuestionDto save(QuestionDto questionDto);

    QuestionDto update(QuestionDto questionDto);

    void delete(Long questionId);

    QuestionChoiceDto findByPollIdAndIdNotIn(Long pollId, List<Long> answerIds);

    boolean existsByPoll_Id(Long pollId);


}

