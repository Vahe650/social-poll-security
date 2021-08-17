package com.social.poll.socialpoll.controller;

import com.social.poll.socialpoll.dto.QuestionDto;
import com.social.poll.socialpoll.service.QuestionSerivce;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "admin/question")
public class QuestionEndpoint {

    private final QuestionSerivce questionSerivce;

    public QuestionEndpoint(QuestionSerivce questionSerivce) {
        this.questionSerivce = questionSerivce;
    }

    @GetMapping
    public List<QuestionDto> getAll() {
        return questionSerivce.findAll();
    }

    @PostMapping
    public QuestionDto create(@RequestBody QuestionDto questionDto) {
        return questionSerivce.save(questionDto);
    }

    @PutMapping
    public QuestionDto update(@RequestBody QuestionDto questionDto) {
        return questionSerivce.update(questionDto);
    }

    @DeleteMapping("/{questionId}")
    public ResponseEntity delete(@PathVariable Long questionId) {
        questionSerivce.delete(questionId);
        return ResponseEntity.ok().build();
    }
}

