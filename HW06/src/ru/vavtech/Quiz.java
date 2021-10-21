package ru.vavtech;

import java.util.Scanner;

public class Quiz {
    //Массив с вопросами
    private static final String[] QUESTIONS = {
            "Сколько будет 1+1?",
            "Как зовут глухого кролика?",
            "Windows must die?"
    };

    //Массив с ответами
    private static final String[] ANSWERS = {
            "1. 2;2. Смотря в какой системе счисления.;3. 1 - я люблю JavaScript!",
            "1. Банни.;2. Роджер;3. Эй ты!;4. КРООООЛИК!!!!",
            "1. Да.;2. Да!!!;3. Yes!;4. Да но XP был неплох."
    };

    //Массив с номерами правильных ответов
    private static final char[] RIGHT_ANSWERS = {'1', '4', '4'};

    // Переменная для хранения счета пользователя
    private static int count = 0;

    public static void main(String[] args) {
        //Обработка пользовательского ввода
        System.out.println("""
                Добро пожаловать!
                Сейчас вам будет предложено ответить на несколько вопросов.
                Готовы начать? (Y/n)
                """);
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equalsIgnoreCase("Y")) {
            while (true) {
                for (int i = 0; i < QUESTIONS.length; i++) {
                    String question = QUESTIONS[i];
                    System.out.println(question);
                    System.out.println("Варианты ответа:");
                    for (String answer : ANSWERS[i].split(";")) {
                        System.out.println(answer);
                    }
                    System.out.println("Введите номер вашего варианта ответа:");
                    char userAnswer = scanner.next().charAt(0);
                    if (Character.isDigit(userAnswer)) {
                        System.out.println("Вы ввели: " + userAnswer);
                        if (RIGHT_ANSWERS[i]==userAnswer) {
                            count++;
                        }
                        System.out.println("================================\n");
                    } else {
                        System.out.println("Можно вводить только цифры! Ответ не защитан.");
                    }
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
}
