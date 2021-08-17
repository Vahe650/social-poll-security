package com.social.poll.socialpoll.repo;

import com.social.poll.socialpoll.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    Question findTop1ByPoll_Id(Long pollId);
    Question findTop1ByPoll_IdAndIdNotIn(Long pollId, List<Long> ids);

    boolean existsByPoll_Id(Long pollId);
}
