package com.social.poll.socialpoll.service;


import com.social.poll.socialpoll.dto.PollDto;

import java.util.List;

public interface PollService {

    List<PollDto> findAll();

    PollDto save(PollDto pollDto);

    PollDto update(PollDto pollDto);

    void delete(Long pollId);

    PollDto findById(Long id);

    PollDto findByTitle(String title);

    List<PollDto> findActivePolls();
}

