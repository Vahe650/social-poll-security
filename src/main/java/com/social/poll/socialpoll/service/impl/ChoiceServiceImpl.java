package com.social.poll.socialpoll.service.impl;


import com.social.poll.socialpoll.dto.ChoiceDto;
import com.social.poll.socialpoll.entity.Choice;
import com.social.poll.socialpoll.mapper.ChoiceEntityMapper;
import com.social.poll.socialpoll.repo.ChoiceRepository;
import com.social.poll.socialpoll.service.ChoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChoiceServiceImpl implements ChoiceService {

    private final ChoiceEntityMapper choiceEntityMapper;

    private final ChoiceRepository choiceRepository;


    @Override
    public List<ChoiceDto> findAllByQuestionId(Long pollId) {
        List<Choice> allByQuestion = choiceRepository.findAllByQuestion_Id(pollId);
        return choiceEntityMapper.toDto(allByQuestion);
    }

    @Override
    public ChoiceDto save(ChoiceDto choiceDto) {
        Choice choice = choiceEntityMapper.toEntity(choiceDto);
        return choiceEntityMapper.toDto(choiceRepository.save(choice));
    }

    @Override
    public ChoiceDto update(ChoiceDto choiceDto) {
        return save(choiceDto);
    }

    @Override
    public void delete(Long optionId) {
        choiceRepository.deleteById(optionId);

    }

    @Override
    public ChoiceDto findById(Long id) {
        Choice choice = choiceRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return choiceEntityMapper.toDto(choice);
    }
}

