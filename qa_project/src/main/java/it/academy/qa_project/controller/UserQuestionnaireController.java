package it.academy.qa_project.controller;

import it.academy.qa_project.entity.Questionnaire;
import it.academy.qa_project.entity.User;
import it.academy.qa_project.entity.UserQuestionnaire;
import it.academy.qa_project.service.UserQuestionnaireService;
import it.academy.qa_project.service.impl.QuestionnaireServiceImpl;
import it.academy.qa_project.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-questionnaires")
public class UserQuestionnaireController {
    @Autowired
    private UserQuestionnaireService userQuestionnaireService;
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private QuestionnaireServiceImpl questionnaireServiceImpl;

    @PostMapping("/new")
    public ResponseEntity<UserQuestionnaire> createUserQuestionnaire(@RequestParam User user, @RequestParam Questionnaire questionnaire,
                                                                     @RequestBody UserQuestionnaire userQuestionnaire) {
        User newUser = userServiceImpl.getUserById(user.getId());
        Questionnaire newQuestionnaire = questionnaireServiceImpl.getQuestionnaireById(questionnaire.getId());
        UserQuestionnaire newUserQuestionnaire = userQuestionnaireService.createUserQuestionnaire(newUser, newQuestionnaire);
        return ResponseEntity.ok(newUserQuestionnaire);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<UserQuestionnaire>> getUserQuestionnairesByUser(@PathVariable Long id) {
        User user = userServiceImpl.getUserById(id);
        List<UserQuestionnaire> userQuestionnaires = userQuestionnaireService.getUserQuestionnairesByUser(user);
        return  ResponseEntity.ok(userQuestionnaires);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserQuestionnaire> getUserQuestionnaireById(@PathVariable Long id) {
        UserQuestionnaire userQuestionnaire = userQuestionnaireService.getUserQuestionnaireById(id);
        return ResponseEntity.ok(userQuestionnaire);
    }
}
