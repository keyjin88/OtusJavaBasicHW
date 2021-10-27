package ru.vavtech.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Класс для описания ответа на вопрос
 */
@Data
@AllArgsConstructor
public class Answer {
    /**
     * Текст вопроса
     */
    private String text;
    /**
     * Флаг говорящий нам, что ответ является верным
     */
    private boolean isRight;
}
