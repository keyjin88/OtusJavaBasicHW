package ru.vavtech.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Сервис по проведению платежных операций
 */
public class BankService {
    private final Map<Long, Client> clientMap;
    private final Map<Long, List<Account>> accountMap;

    public BankService() {
        clientMap = new TreeMap<>();
        accountMap = new TreeMap<>();
    }

    /**
     * Добавляет клиента в список клиентов банка
     * @param client клиент
     */
    public void addClientAccount(Long accountId, Client client) {
        clientMap.put(accountId, client);
    }

    /**
     * Добавляет счет в список всех счетов по ключу id клиента, к которому счет относится
     * @param clientId идентефикатор клиента
     * @param account  счет
     */
    public void addAccount(Long clientId, Account account) {
        if (accountMap.get(clientId) == null) {
            var accountList = new ArrayList<Account>();
            accountList.add(account);
            accountMap.put(clientId, accountList);
        } else {
            accountMap.get(clientId).add(account);
        }
    }

    /**
     * Возвращает все счета клиента
     * @param clientId идентефикатор клиента
     * @return список счетов клиента
     */
    public List<Account> getAccountsByClientId(Long clientId) {
        return accountMap.get(clientId);
    }

    /**
     * Ищет клиента по его счету среди всех клиентов банка
     * @param accountId id счета клиента
     * @return ифнормацию о клиенте
     */
    public Client findPerson(Long accountId) {
        return clientMap.get(accountId);
    }

    /**
     * Совершает перевод между счетами клиентов банка в том числе и между счетами одного клиента
     * @param from   счет с которого происходит списание
     * @param to     счет на который происходит зачисление
     * @param amount сумма транзакции
     * @return {@code true} если транзакция завершена успешно или {@code false}, если перевод не удался
     */
    public boolean transfer(Account from, Account to, BigDecimal amount) {
        var personFrom = findPerson(from.getId());
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
