package ru.vavtech;

import ru.vavtech.service.QuizService;

public class QuizApp {
    public static void main(String[] args) {
        QuizService quizService = new QuizService();
        quizService.startQuiz();
    }
}
