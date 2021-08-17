package com.social.poll.socialpoll.service;

import com.social.poll.socialpoll.dto.AnswerDto;

import java.util.List;

public interface AnswerService {

    List<Long> getAnswerByPollAndUser(Long pollId, Long userId);

    List<AnswerDto> findAllByQuestion_Poll_IdAndUserId(Long pollId, Long useId);

    AnswerDto save(AnswerDto answerDto);

    AnswerDto update(AnswerDto answerDto);

    void delete(Long answerid);

    AnswerDto findById(Long id);

}

