package it.academy.qa_project.entity;

import it.academy.qa_project.entity.enums.TypeAnswer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "questionnaire")
@Getter
@Setter
public class Questionnaire{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title" , nullable = false)
    private String title;

    @Column
    @Enumerated(value = EnumType.STRING)
    private TypeAnswer typeAnswer;
}
