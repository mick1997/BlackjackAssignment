package blackjack.player;

import blackjack.mainEntry.Player;

public class HumanDealer extends Player {

    // instance variable: name
    private String name;

    /**
     * @param; name: String
     * */
    public HumanDealer(String name) {
        super(name);
        this.name = name;
    }

    /**
     * @param: None
     * @return: None
     * think method that override from Player class for implementing more logic thinking
     * */
    @Override
    public void think() {
        System.out.println(String.format("%s is thinking...,", name));
    }
}
