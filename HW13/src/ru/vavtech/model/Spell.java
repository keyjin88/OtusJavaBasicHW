package ru.vavtech.model;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * Заметка
 */
public class Spell {
    /**
     * Уникальный магический отпечаток заклинания
     */
    private UUID id;
    /**
     * Словестная форма заклинания
     */
    private String content;
    /**
     * Дата
     */
    private Date date;

    public Spell(String content) {
        this.content = content;
        this.id = UUID.randomUUID();
        this.date = new Date();
    }

    public UUID getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spell spell = (Spell) o;
        return id.equals(spell.id) && Objects.equals(content, spell.content) && Objects.equals(date, spell.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, date);
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }
}
