package it.academy.qa_project.controller;

import it.academy.qa_project.entity.Answer;
import it.academy.qa_project.entity.Question;
import it.academy.qa_project.service.AnswerService;
import it.academy.qa_project.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
public class AnswerController {
    @Autowired
    private AnswerService answerService;
    @Autowired
    private QuestionService questionService;

    @PostMapping
    public ResponseEntity<?> createAnswer(@RequestParam String text, @RequestParam Long question) {
        Answer answer = answerService.createAnswer(text, question);
        return ResponseEntity.ok(answer);
    }

    @GetMapping("/question/{id}")
    public ResponseEntity<?> getAnswersByQuestion(@PathVariable Long id) {
        Question question = questionService.getQuestionById(id);
        List<Answer> answers = answerService.getAnswersByQuestion(question);
        return ResponseEntity.ok(answers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAnswerById(@PathVariable Long id) {
        Answer answer = answerService.getAnswerById(id);
        return ResponseEntity.ok(answer);
    }

}




