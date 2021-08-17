package com.social.poll.socialpoll.controller;


import com.social.poll.socialpoll.dto.AnswerDto;
import com.social.poll.socialpoll.dto.PollDto;
import com.social.poll.socialpoll.dto.QuestionChoiceDto;
import com.social.poll.socialpoll.service.AnswerService;
import com.social.poll.socialpoll.service.PollService;
import com.social.poll.socialpoll.service.QuestionSerivce;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "answer")
public class AnswerEndpoint {

    private final AnswerService answerService;
    private final PollService pollService;
    private final QuestionSerivce questionSerivce;

    public AnswerEndpoint(AnswerService answerService, PollService pollService, QuestionSerivce questionSerivce) {
        this.answerService = answerService;
        this.pollService = pollService;
        this.questionSerivce = questionSerivce;
    }

    @GetMapping
    public List<AnswerDto> getAllByPoll(@RequestParam Long pollId, @RequestParam Long userId) {
        return answerService.findAllByQuestion_Poll_IdAndUserId(pollId, userId);
    }


    @PostMapping
    public AnswerDto create(@RequestBody AnswerDto answerDto) {
        return answerService.save(answerDto);
    }

    @GetMapping("/active-polls")
    public List<PollDto> getActivePolls() {
        return pollService.findActivePolls();
    }

    @GetMapping("/get-question")
    public QuestionChoiceDto getNextQuestion(@RequestParam Long pollId, @RequestParam Long userId) {
        List<Long> answerIdsByPollAndUser = answerService.getAnswerByPollAndUser(pollId, userId);
        return questionSerivce.findByPollIdAndIdNotIn(pollId, answerIdsByPollAndUser);
    }


}

