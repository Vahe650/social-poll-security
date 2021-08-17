package com.social.poll.socialpoll.service;


import com.social.poll.socialpoll.dto.ChoiceDto;

import java.util.List;

public interface ChoiceService {

    List<ChoiceDto> findAllByQuestionId(Long pollId);

    ChoiceDto save(ChoiceDto choiceDto);

    ChoiceDto update(ChoiceDto choiceDto);

    void delete(Long optionId);

    ChoiceDto findById(Long id);

}

