package ru.vavtech.tests.mock;

import ru.vavtech.game.GameWinnerPrinter;
import ru.vavtech.game.Player;

public class GameWinnerPrinterMock implements GameWinnerPrinter {

    private static int counter = 0;
    private String actual;

    @Override
    public void printWinner(Player winner) {
        actual = winner.getName();
        counter++;
    }

    public String getStatistic() {
        int temp = counter;
        counter = 0;
        return String.format("Mock вызывался %d раз", temp);
    }

    public String getActual() {
        return actual;
    }
}
