package blackjack.player;


import blackjack.mainEntry.Player;

public class HumanPlayer extends Player {

    private String name;

    public HumanPlayer(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void think() {
        System.out.println(String.format("player %s thinking...", name));
    }
}
