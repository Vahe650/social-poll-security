package com.social.poll.socialpoll.service.impl;


import com.social.poll.socialpoll.dto.ChoiceDto;
import com.social.poll.socialpoll.dto.QuestionChoiceDto;
import com.social.poll.socialpoll.dto.QuestionDto;
import com.social.poll.socialpoll.entity.Question;
import com.social.poll.socialpoll.mapper.QuestionEntityMapper;
import com.social.poll.socialpoll.repo.QuestionRepository;
import com.social.poll.socialpoll.service.ChoiceService;
import com.social.poll.socialpoll.service.QuestionSerivce;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionSerivce {

    private final QuestionEntityMapper questionEntityMapper;

    private final QuestionRepository questionRepository;
    private final ChoiceService choiceService;


    public QuestionServiceImpl(QuestionEntityMapper questionEntityMapper, QuestionRepository questionRepository, ChoiceService choiceService) {
        this.questionEntityMapper = questionEntityMapper;
        this.questionRepository = questionRepository;
        this.choiceService = choiceService;
    }


    @Override
    public List<QuestionDto> findAll() {
        List<Question> resultList = questionRepository.findAll();
        return questionEntityMapper.toDto(resultList);
    }

    @Override
    public QuestionDto save(QuestionDto questionDto) {
        if (questionDto.getPoll().getStartDate() != null) {
            throw new RuntimeException("You can not change this question,because poll has started already");
        }
        Question question = questionEntityMapper.toEntity(questionDto);
        question = questionRepository.save(question);
        return questionEntityMapper.toDto(question);
    }

    @Override
    public QuestionDto update(QuestionDto questionDto) {
        return save(questionDto);
    }

    @Override
    public void delete(Long questionId) {
        questionRepository.deleteById(questionId);
    }

    @Override
    public QuestionChoiceDto findByPollIdAndIdNotIn(Long pollId, List<Long> answerIds) {
        if (!existsByPoll_Id(pollId)) throw new RuntimeException("There is no any question in this poll yet");
        Question nexQuestion = answerIds.isEmpty() ? questionRepository.findTop1ByPoll_Id(pollId) : questionRepository.findTop1ByPoll_IdAndIdNotIn(pollId, answerIds);
        if (nexQuestion == null) {
            throw new RuntimeException("You have passed the poll with " + pollId + " id");
        }
        QuestionDto questionDto = questionEntityMapper.toDto(nexQuestion);
        List<ChoiceDto> allByQuestionId = choiceService.findAllByQuestionId(questionDto.getId());
        QuestionChoiceDto questionChoiceDto = new QuestionChoiceDto();
        questionChoiceDto.setQuestion(questionDto);
        questionChoiceDto.setChoices(allByQuestionId);
        return questionChoiceDto;
    }

    @Override
    public boolean existsByPoll_Id(Long pollId) {
        return questionRepository.existsByPoll_Id(pollId);
    }
}

