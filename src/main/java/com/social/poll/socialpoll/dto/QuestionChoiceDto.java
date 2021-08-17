package com.social.poll.socialpoll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionChoiceDto {
    private QuestionDto question;
    private List<ChoiceDto> choices;


}

