package ru.vavtech.service;

import ru.vavtech.model.Answer;
import ru.vavtech.model.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Сервисный класс для работы с вопросами. Пока умеет только возвращать заполненную коллекцию с вопросами
 */
public class QuestionService {
    /**
     * Метод возвращает заполненный список с вопросами
     *
     * @return список вопросов
     */
    public static List<Question> getQuestionsList() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(
                        "Сколько будет 1+1?",
                        List.of(new Answer("2.", true),
                                new Answer("Смотря в какой системе счисления.", false),
                                new Answer("1 - я люблю JavaScript!", false)
                        )
                )
        );
        questions.add(new Question(
                        "Как зовут глухого кролика?",
                        List.of(
                                new Answer("Банни.", false),
                                new Answer("Роджер.", false),
                                new Answer("Эй ты!", false),
                                new Answer("КРООООЛИК!!!!", true)
                        )
                )
        );
        questions.add(new Question(
                        "Windows must die?",
                        List.of(
                                new Answer("Да.", false),
                                new Answer("Да!!!", false),
                                new Answer("Yes!", false),
                                new Answer("Да но XP был неплох.", true)
                        )
                )
        );
        return questions;
    }
}
