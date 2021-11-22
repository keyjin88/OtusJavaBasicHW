package ru.vavtech;

import ru.vavtech.service.SpellBookService;

import java.util.UUID;

public class SpellBookApp {
    public static void main(String[] args) {
        var spellBookService = new SpellBookService();
        var note1 = spellBookService.addNewSpell();

        spellBookService.showAllNotes();

        spellBookService.findSpellById(note1.getId());
        spellBookService.findSpellById(UUID.fromString("20123e49-9c1e-4d94-b693-bb99cf8ea211"));
    }
}
