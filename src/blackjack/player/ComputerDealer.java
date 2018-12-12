package blackjack.player;

import blackjack.mainEntry.Player;

public class ComputerDealer extends Player {

    private String name;

    public ComputerDealer(String name) {
        super(name);
        this.name = name;
    }

    // todo: I have implementing think method, somehow it works
    @Override
    public void think() {

        boolean keepThink = true;
        System.out.println(String.format("%s thinking...", name));

        while (keepThink) {
            if (!isBlackJack() || !isBusted()) {
                System.out.println("The Computer dealer decide to draw card");
                keepThink = false;
            }
            else {
                System.out.println("The Computer dealer win the game!!!");
                keepThink = false;
            }
        }
    }
}
