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

        boolean keepThink = true;
        System.out.println(String.format("%s thinking...", name));

        while (keepThink) {
            System.out.println("The player decide to draw card");
            keepThink = false;
        }

    }

    public void placeBet(int amount) {
        System.out.println(String.format("The amount of bet is place %s", amount));
    }
}
