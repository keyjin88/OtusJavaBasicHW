package ru.vavtech.exception;

/**
 * Ошибка поиска заклинания
 */
public class SpellNotFoundException extends IllegalArgumentException {
    public SpellNotFoundException(String message) {
        super(message);
    }
}
