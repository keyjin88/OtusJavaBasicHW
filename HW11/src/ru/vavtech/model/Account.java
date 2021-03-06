package ru.vavtech.model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Счет клиента
 */
public class Account implements Comparable<Account> {
    /**
     * ID сета
     */
    private Long id;

    /**
     * Сумма на счету
     */
    private BigDecimal amount;

    public Account(long id, BigDecimal amount) {
        this.id = id;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(amount, account.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount);
    }

    @Override
    public int compareTo(Account account) {
        return id.compareTo(account.getId());
    }
}
