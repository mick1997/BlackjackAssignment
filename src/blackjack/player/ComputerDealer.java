package blackjack.player;

import blackjack.mainEntry.Player;

public class ComputerDealer extends Player {

    private String name;

    public ComputerDealer(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void think() {
        System.out.println(String.format("Computer %s thinking..., and make round more fun", name));
    }
}
