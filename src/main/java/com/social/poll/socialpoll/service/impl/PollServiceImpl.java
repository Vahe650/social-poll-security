package com.social.poll.socialpoll.service.impl;

import com.social.poll.socialpoll.dto.PollDto;
import com.social.poll.socialpoll.entity.Poll;
import com.social.poll.socialpoll.mapper.PollEntityMapper;
import com.social.poll.socialpoll.repo.PollRepository;
import com.social.poll.socialpoll.service.PollService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PollServiceImpl implements PollService {

    private final PollEntityMapper pollEntityMapper;

    private final PollRepository pollRepository;

    public PollServiceImpl(PollEntityMapper pollEntityMapper, PollRepository pollRepository) {
        this.pollEntityMapper = pollEntityMapper;
        this.pollRepository = pollRepository;
    }


    @Override
    public List<PollDto> findAll() {
        List<Poll> resultList = pollRepository.findAll();
        return resultList.stream().map(pollEntityMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public PollDto save(PollDto pollDto) {
        Poll poll = pollEntityMapper.toEntity(pollDto);
        poll = pollRepository.save(poll);
        return pollEntityMapper.toDto(poll);
    }

    @Override
    public PollDto update(PollDto pollDto) {
        return save(pollDto);
    }

    @Override
    public void delete(Long pollId) {
        pollRepository.deleteById(pollId);
    }

    @Override
    public PollDto findById(Long id) {
        Poll poll = pollRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return pollEntityMapper.toDto(poll);
    }

    @Override
    public PollDto findByTitle(String title) {
        Poll poll = pollRepository.findByTitle(title).orElseThrow(EntityNotFoundException::new);
        return pollEntityMapper.toDto(poll);
    }

    @Override
    public List<PollDto>findActivePolls() {
        List<Poll> resultList = pollRepository.findByStartDateNotNullAndEndDateGreaterThan(LocalDate.now());
        return pollEntityMapper.toDto(resultList);
    }
}

