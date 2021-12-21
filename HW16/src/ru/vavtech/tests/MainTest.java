package ru.vavtech.tests;

public class MainTest {
    public static void main(String[] args) {

        new GameImplTest().testForNormalWork();
        new DiceImplTest().testRolledDieValue();
        new GameImplTest().testForNullPointerException();
        new GameImplTest().testForNullPlayer();
        new GameImplTest().testForWrongWork();
        new GameImplTest().test();
    }
}
