package it.academy.qa_project.service;

import it.academy.qa_project.entity.Answer;
import it.academy.qa_project.entity.Question;

import java.util.List;

public interface AnswerService {


    Answer createAnswer(String text, Long question);

    List<Answer> getAnswersByQuestion(Question question);

    Answer getAnswerById(Long id);
}
