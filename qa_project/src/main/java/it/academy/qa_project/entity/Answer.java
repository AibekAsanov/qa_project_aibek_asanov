package it.academy.qa_project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Entity
@Table(name = "answer")
@Getter
@Setter
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description", nullable = false)
    private String text;
    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;
}
