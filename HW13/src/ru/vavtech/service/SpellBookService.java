package ru.vavtech.service;

import ru.vavtech.exception.SpellNotFoundException;
import ru.vavtech.model.Spell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SpellBookService {

    private final List<Spell> spells = new ArrayList<>();

    /**
     * Поиск заклинания по магическому отпечатку. Вывод ошибки
     * @param uuid магический отпечаток
     * @return заклинание
     */
    public Spell findSpellById(UUID uuid) {
        var note = spells.
                stream()
                .filter(s -> s.getId().equals(uuid))
                .findFirst()
                .orElse(null);
        if (note == null) {
            throw new SpellNotFoundException("Заклинания с отпечатком " + uuid.toString() + " не найдено");
        }
        return note;
    }

    /**
     * Вывод в консоль всех заклинания
     */
    public void showAllNotes() {
        spells.forEach(System.out::println);
    }

    /**
     * Метод добавления нового заклинания (обработка исключения)
     * @return заклинание
     */
    public Spell addNewSpell() {
        Spell spell = null;
        try {
            var string = readStringFromKeyboard("Введите текст заклинания");
            spell = new Spell(string);
            spells.add(spell);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return spell;
    }

    /**
     * Метод для запроса строки от пользователя (rethrow)
     * @return введенная пользователем строка
     */
    private String readStringFromKeyboard(String message) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(message);
            return reader.readLine();
        }
    }

}
