package blackjack.player;

import blackjack.mainEntry.Player;

public class HumanDealer extends Player {

    private String name;

    public HumanDealer(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void think() {
        boolean keepThink = true;
        System.out.println(String.format("%s thinking...,", name));

        while (keepThink) {
            System.out.println("Human dealer decide to draw card");

        }
    }
}
