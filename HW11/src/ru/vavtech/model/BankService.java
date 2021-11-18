package ru.vavtech.model;

import java.math.BigDecimal;
import java.util.Set;
import java.util.TreeSet;

/**
 * Сервис по проведению платежных операций
 */
public class BankService {
    private final Set<Client> clientList;

    public BankService() {
        clientList = new TreeSet<>();
    }

    /**
     * Добавляет клиента в список клиентов банка
     * @param client клиент
     */
    public void addClient(Client client) {
        clientList.add(client);
    }

    /**
     * Ищет клиента по его счету среди всех клиентов банка
     * @param account счет клиента
     * @return ифнормацию о клиенте
     */
    public Client findPerson(Account account) {
        return clientList.stream()
                .filter(client -> client.getAccountList().contains(account))
                .findFirst()
                .orElse(null);
    }

    /**
     * Совершает перевод между счетами клиентов банка в том числе и между счетами одного клиента
     * @param from   счет с которого происходит списание
     * @param to     счет на который происходит зачисление
     * @param amount сумма транзакции
     * @return {@code true} если транзакция завершена успешно или {@code false}, если перевод не удался
     */
    public boolean transfer(Account from, Account to, BigDecimal amount) {
        var personFrom = findPerson(from);
        if (!checkAge(personFrom)) {
            System.out.println("Перевод со счета пользователя запрещен.\n" +
                    "Золотом можно распоряжаться только с 18-ти лет");
            return false;
        }
        if (from.getAmount().compareTo(amount) >= 0) {
            System.out.println("Перевод со счета: " + from.getId() +
                    " на счет: " + to.getId() + " суммы: " + amount.doubleValue());
            from.setAmount(from.getAmount().subtract(amount));
            to.setAmount(to.getAmount().add(amount));
            return true;
        } else {
            System.out.println("Невозможно перевести больше золота, чем есть на счете.\n" +
                    "Магия вне Хогвартса запрещена!");
            return false;
        }
    }

    /**
     * Проверяет возраст клиента
     * @param client клиент
     * @return {@code true} если транзакция может быть совершена или {@code false}, если нет
     */
    private boolean checkAge(Client client) {
        return client.getAge() >= 18;
    }
}
