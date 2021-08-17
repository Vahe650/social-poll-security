package com.social.poll.socialpoll.dto;

import com.social.poll.socialpoll.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {
    private Long id;
    private Long number;
    private String question;
    private PollDto poll;
    private Question.QuestionType questionType;


}

