package com.social.poll.socialpoll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChoiceDto {
    private Long id;
    private String value;
    private QuestionDto question;
}

