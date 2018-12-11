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
        System.out.println(String.format("Human %s thinking...", name));
    }
}
