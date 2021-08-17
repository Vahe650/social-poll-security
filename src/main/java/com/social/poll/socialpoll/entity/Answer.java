package com.social.poll.socialpoll.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "answers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "answer_choices",
            joinColumns = { @JoinColumn(name = "answer_id") },
            inverseJoinColumns = { @JoinColumn(name = "choice_id") }
    )
    Set<Choice> choices = new HashSet<>();
    @Column
    private String textValue;
    @ManyToOne
    private Question question;
    @Column
    private Long userId;


}

