package ru.vavtech.model;

import java.util.List;

/**
 * Класс для описания вопроса
 */
public class Question {
    /**
     * Текст вопроса
     */
    private String text;
    /**
     * Список ответов на данный вопрос
     */
    private List<Answer> answers;

    public Question(String text, List<Answer> answers) {
        this.text = text;
        this.answers = answers;
    }

    public String getText() {
        return text;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}
