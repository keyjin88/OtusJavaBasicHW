package ru.vavtech;

import java.util.List;
import java.util.Scanner;

public class Quizz {

    public static void main(String[] args) {
        // Переменная для хранения счета пользователя
        int count = 0;
        //Массив с вопросами
        String[] questions = {
                "Сколько будет 1+1?",
                "Как зовут глухого кролика?",
                "Windows must die?"
        };
        //Массив с ответами
        String[] answers = {
                "1. 2;2. Смотря в какой системе счисления.;3. 1 - я люблю JavaScript!",
                "1. Банни.;2. Роджер;3. Эй ты!;4. КРООООЛИК!!!!",
                "1. Да.;2. Да!!!;3. Yes!;4. Да но XP был неплох."
        };
        //Массив с номерами правильных ответов
        int[] rightAnswers = {1, 4, 4};

        //Обработка пользовательского ввода
        System.out.println("""
                Добро пожаловать!
                Сейчас вам будет предложено ответить на несколько вопросов.
                Готовы начать? (Y/n)
                """);
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equalsIgnoreCase("Y")) {
            for (int i = 0; i < questions.length; i++) {
                String question = questions[i];
                System.out.println(question);
                System.out.println("Варианты ответа:");
                for (String answer : answers[i].split(";")) {
                    System.out.println(answer);
                }
                System.out.println("Введите номер вашего варианта ответа:");
                int userAnswer = scanner.nextInt();
                System.out.println("Вы ввели: " + userAnswer);
                if (userAnswer == rightAnswers[i]) {
                    count++;
                }
                System.out.println("================================\n");
            }
            System.out.println("Поздравляем! Количество правильных ответов: " + count);
        } else {
            System.out.println("Ну и зря! Всего доброго.");
        }
    }
}
