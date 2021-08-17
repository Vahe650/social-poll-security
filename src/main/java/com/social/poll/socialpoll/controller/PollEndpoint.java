package com.social.poll.socialpoll.controller;

import com.social.poll.socialpoll.dto.PollDto;
import com.social.poll.socialpoll.service.PollService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "admin/poll")
public class PollEndpoint {

    private final PollService pollService;

    public PollEndpoint(PollService pollService) {
        this.pollService = pollService;
    }

    @GetMapping
    public List<PollDto> getAll() {
        return pollService.findAll();
    }

    @PostMapping
    public PollDto create(@RequestBody PollDto pollDto) {
        return pollService.save(pollDto);
    }

    @PutMapping
    public PollDto update(@RequestBody PollDto pollDto) {
        return pollService.update(pollDto);
    }

    @DeleteMapping("/{pollId}")
    public ResponseEntity delete(@PathVariable Long pollId) {
        pollService.delete(pollId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search-title")
    public PollDto getByTitle(@RequestParam String title) {
        return pollService.findByTitle(title);
    }

    @GetMapping("/search-id")
    public PollDto getById(@RequestParam Long id) {
        return pollService.findById(id);
    }


}

