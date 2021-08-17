package com.social.poll.socialpoll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PollDto {
    private Long id;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
}

