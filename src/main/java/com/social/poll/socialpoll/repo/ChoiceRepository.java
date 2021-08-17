package com.social.poll.socialpoll.repo;

import com.social.poll.socialpoll.entity.Choice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChoiceRepository extends JpaRepository<Choice, Long> {

    List<Choice> findAllByQuestion_Id(Long pollId);
}
