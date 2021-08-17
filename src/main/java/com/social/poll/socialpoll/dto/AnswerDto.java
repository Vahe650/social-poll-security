package com.social.poll.socialpoll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDto {
    private Long id;
    Set<ChoiceDto> choices = new HashSet<>();
    private QuestionDto question;
    private Long userId;
    private String textValue;
}

