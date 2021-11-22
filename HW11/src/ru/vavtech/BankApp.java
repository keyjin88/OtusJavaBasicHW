package ru.vavtech;

import ru.vavtech.model.Account;
import ru.vavtech.model.BankService;
import ru.vavtech.model.Client;

import java.math.BigDecimal;

public class BankApp {

    public static void main(String[] args) {
        //Создаем банк
        BankService bankService = new BankService();

        //Создаем пользователей и заводим им счета
        Client alexander = new Client(1L, "Alex", 17);
        Account alexAccount1 = new Account(1L, new BigDecimal("10000"));
        Account alexAccount2 = new Account(2L, new BigDecimal("3000"));

        Client pavel = new Client(2L, "Alex", 33);
        Account pavelAccount1 = new Account(3L, new BigDecimal("15000"));

        //Подгружаем пользователей и счета в банк
        bankService.addClientAccount(alexAccount1.getId(), alexander);
        bankService.addClientAccount(alexAccount2.getId(), alexander);
        bankService.addClientAccount(pavelAccount1.getId(), pavel);

        bankService.addAccount(alexander.getId(), alexAccount1);
        bankService.addAccount(alexander.getId(), alexAccount2);
        bankService.addAccount(pavel.getId(), pavelAccount1);

        //Пробуем найти пользователя по его счету
        var person = bankService.findPerson(alexAccount2.getId());
        System.out.println(person.getName());

        //Проводим переводы до тех пор пока не кончатся деньги на счете
        bankService.transfer(pavelAccount1, alexAccount2, new BigDecimal("5000"));
        bankService.transfer(pavelAccount1, alexAccount2, new BigDecimal("5000"));
        bankService.transfer(pavelAccount1, alexAccount2, new BigDecimal("5000"));
        bankService.transfer(pavelAccount1, alexAccount2, new BigDecimal("5000"));

        //Проверяем работоспособность ограничения по возрасту
        bankService.transfer(alexAccount2, pavelAccount1, new BigDecimal("3000"));
    }
}
