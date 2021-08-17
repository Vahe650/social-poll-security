package com.social.poll.socialpoll.service.impl;

import com.social.poll.socialpoll.dto.AnswerDto;
import com.social.poll.socialpoll.entity.Answer;
import com.social.poll.socialpoll.mapper.AnswerEntityMapper;
import com.social.poll.socialpoll.repo.AnswerRepository;
import com.social.poll.socialpoll.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerEntityMapper answerEntityMapper;

    private final AnswerRepository answerRepository;


    @Override
    public List<Long> getAnswerByPollAndUser(Long pollId, Long userId) {
        return answerRepository.getAnswerByPollAndUser(pollId,userId);
    }

    @Override
    public List<AnswerDto> findAllByQuestion_Poll_IdAndUserId(Long pollId, Long userId) {
        List<Answer> allByQuestion_poll_idAndUserId = answerRepository.findAllByQuestion_Poll_IdAndUserId(pollId, userId);
        return answerEntityMapper.toDto(allByQuestion_poll_idAndUserId);
    }

    @Override
    public AnswerDto save(AnswerDto answerDto) {
        Answer answer = answerEntityMapper.toEntity(answerDto);
        return answerEntityMapper.toDto(answerRepository.save(answer));
    }

    @Override
    public AnswerDto update(AnswerDto answerDto) {
        return save(answerDto);
    }

    @Override
    public void delete(Long answerid) {
        answerRepository.deleteById(answerid);
    }

    @Override
    public AnswerDto findById(Long id) {
        Answer answer = answerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return answerEntityMapper.toDto(answer);
    }
}

