package it.academy.qa_project.controller;

import it.academy.qa_project.entity.Questionnaire;
import it.academy.qa_project.entity.enums.TypeAnswer;
import it.academy.qa_project.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {
    @Autowired
    private QuestionnaireService questionnaireService;

    @PostMapping("/new")
    public ResponseEntity<?> createQuestionnaire(@RequestParam String text, @RequestParam TypeAnswer type) {
        Questionnaire newQuestionnaire = questionnaireService.createQuestionnaire(text, type);
        return ResponseEntity.ok(newQuestionnaire);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Questionnaire>> getAllQuestionnaires() {
        List<Questionnaire> questionnaires = questionnaireService.getAllQuestionnaires();
        return ResponseEntity.ok(questionnaires);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Questionnaire> getQuestionnaireById(@PathVariable Long id) {
        Questionnaire questionnaire = questionnaireService.getQuestionnaireById(id);
        return ResponseEntity.ok(questionnaire);
    }
    @DeleteMapping("/{id}")
    public void deleteQuestionnaire(@PathVariable Long id) {
        questionnaireService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestParam String title, @RequestParam TypeAnswer newType) {
        return ResponseEntity.ok(questionnaireService.update(id, title, newType));
    }
}
