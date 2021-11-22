package ru.vavtech.model;

import java.util.Objects;

/**
 * Клиент банка
 */
public class Client implements Comparable<Client> {
    /**
     * ID клиента
     */
    private Long id;
    /**
     * Имя клиента
     */
    private String name;
    /**
     * Возраст клиента
     */
    private int age;

    public Client(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && age == client.age && Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    @Override
    public int compareTo(Client client) {
        return id.compareTo(client.getId());
    }
}
