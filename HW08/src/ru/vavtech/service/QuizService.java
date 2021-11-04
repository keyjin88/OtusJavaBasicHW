package ru.vavtech.service;

import ru.vavtech.model.Answer;
import ru.vavtech.model.Question;

import java.text.MessageFormat;
import java.util.List;
import java.util.Scanner;

/**
 * Собственно сервис опросника. Умеет задавать вопросы и проверять ответы пользователя
 */
public class QuizService {

    // Вопросы
    private final List<Question> questions;
    // Переменная для хранения счета пользователя
    private int count = 0;

    public QuizService() {
        questions = QuestionService.getQuestionsList();
    }

    /**
     * Метод проводит викторины
     */
    public void startQuiz() {
        System.out.println("""
                Добро пожаловать!
                Сейчас вам будет предложено ответить на несколько вопросов.
                Готовы начать? (Y/n)
                """);
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equalsIgnoreCase("Y")) {
            while (true) {
                for (Question question : questions) {
                    System.out.println(question.getText());
                    System.out.println("Варианты ответа:");
                    int answerNumber = 1;
                    for (Answer answer : question.getAnswers()) {
                        System.out.println(
                                MessageFormat.format("{0}. {1}", answerNumber, answer.getText()
                                ));
                        answerNumber++;
                    }
                    System.out.println("Введите номер вашего варианта ответа:");
                    String userAnswer = scanner.next();
                    checkAnswer(question, userAnswer);
                }
                System.out.println("Поздравляем! Количество правильных ответов: " + count + "\n");
                System.out.println("Желаете повторить?(Y/n)");
                String isUserContinue = scanner.next();
                if (isUserContinue.equalsIgnoreCase("N")) {
                    System.out.println("До встречи!");
                    break;
                }
            }
        } else {
            System.out.println("Ну и зря! Всего доброго.");
        }
        scanner.close();
    }

    /**
     * Метод для проверки пользовательского ответа
     *
     * @param question   вопрос
     * @param userAnswer вариант ответа пользователя
     */
    private void checkAnswer(Question question, String userAnswer) {
        for (char c : userAnswer.toCharArray()) {
            if (!Character.isDigit(c)) {
                System.out.println("Можно вводить только цифры! Ответ не защитан.");
                System.out.println("================================\n");
                return;
            }
        }
        System.out.println("Вы ввели: " + userAnswer);
        if (question.getAnswers().get(Integer.parseInt(userAnswer) - 1).isRight()) {
            count++;
        }
        System.out.println("================================\n");
    }
}
