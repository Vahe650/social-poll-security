package com.social.poll.socialpoll.repo;

import com.social.poll.socialpoll.entity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PollRepository extends JpaRepository<Poll, Long> {
    List<Poll> findByIdOrTitle(Long id, String title);

    List<Poll> findByStartDateNotNullAndEndDateGreaterThan(LocalDate date);

    Optional<Poll> findByTitle(String title);
}
