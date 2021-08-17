package com.social.poll.socialpoll.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "questions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private Long number;
    @Column
    private String question;
    @ManyToOne
    private Poll poll;
    @Column
    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    public enum QuestionType {
        SINGLE,MULTIPLE,TEXT
    }

}

