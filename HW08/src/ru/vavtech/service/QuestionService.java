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
     * @return список вопросов
     */
    public static List<Question> getQuestionsList() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(
                "Сколько будет 1+1?",
                new ArrayList<>() {
                    {
                        add(new Answer("2.", true));
                        add(new Answer("Смотря в какой системе счисления.", false));
                        add(new Answer("1 - я люблю JavaScript!", false));
                    }
                }
        ));
        questions.add(new Question(
                "Как зовут глухого кролика?",
                new ArrayList<>() {
                    {
                        add(new Answer("Банни.", false));
                        add(new Answer("Роджер.", false));
                        add(new Answer("Эй ты!", false));
                        add(new Answer("КРООООЛИК!!!!", true));
                    }
                }
        ));
        questions.add(new Question(
                "Windows must die?",
                new ArrayList<>() {
                    {
                        add(new Answer("Да.", false));
                        add(new Answer("Да!!!", false));
                        add(new Answer("Yes!", false));
                        add(new Answer("Да но XP был неплох.", true));
                    }
                }
        ));
        return questions;
    }

}
