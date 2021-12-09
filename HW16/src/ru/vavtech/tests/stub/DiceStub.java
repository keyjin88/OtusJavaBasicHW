package ru.vavtech.tests.stub;

import ru.vavtech.game.Dice;

public class DiceStub implements Dice {
    private int counter = 0;

    @Override
    public int roll() {
        if (counter == 0) {
            counter++;
            return 5;
        } else {
            return 3;
        }
    }
}
