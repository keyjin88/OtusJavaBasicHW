package ru.vavtech.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Класс для описания вопроса
 */
@Data
@AllArgsConstructor
public class Question {
    /**
     * Текст вопроса
     */
    private String text;
    /**
     * Список ответов на данный вопрос
     */
    private List<Answer> answers;
}
