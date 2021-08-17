package com.social.poll.socialpoll.controller;

import com.social.poll.socialpoll.dto.ChoiceDto;
import com.social.poll.socialpoll.service.ChoiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "admin/option")
public class ChoiceEndpoint {

    private final ChoiceService choiceService;

    public ChoiceEndpoint(ChoiceService choiceService) {
        this.choiceService = choiceService;
    }

    @GetMapping
    public List<ChoiceDto> getAllByQuestion(@RequestParam Long questionId) {
        return choiceService.findAllByQuestionId(questionId);
    }

    @PostMapping
    public ChoiceDto create(@RequestBody ChoiceDto choiceDto) {
        return choiceService.save(choiceDto);
    }

    @PutMapping
    public ChoiceDto update(@RequestBody ChoiceDto choiceDto) {
        return choiceService.update(choiceDto);
    }

    @DeleteMapping("/{optionId}")
    public ResponseEntity delete(@PathVariable Long optionId) {
        choiceService.delete(optionId);
        return ResponseEntity.ok().build();
    }


}

