package com.social.poll.socialpoll.repo;


import com.social.poll.socialpoll.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    List<Answer> findAllByQuestion_Poll_IdAndUserId(Long pollId, Long useId);

    @Query("select a.question.id from Answer a where a.question.poll.id=:pollId and a.userId=:userId")
    List<Long> getAnswerByPollAndUser(@Param("pollId") Long pollId, @Param("userId") Long userId);
}
