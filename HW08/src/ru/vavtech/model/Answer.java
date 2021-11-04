package ru.vavtech.model;

/**
 * Класс для описания ответа на вопрос
 */
public class Answer {
    /**
     * Текст вопроса
     */
    private String text;
    /**
     * Флаг говорящий нам, что ответ является верным
     */
    private boolean isRight;

    public Answer(String text, boolean isRight) {
        this.text = text;
        this.isRight = isRight;
    }

    public String getText() {
        return text;
    }

    public boolean isRight() {
        return isRight;
    }
}
