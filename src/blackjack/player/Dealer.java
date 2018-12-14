package blackjack.player;

import blackjack.mainEntry.Player;

public class Dealer extends Player {

    // instance variable: name
    private String name;

    /**
     * @param; name: String
     * */
    public Dealer(String name) {
        super(name);
        this.name = name;
    }

    /**
     * @param: None
     * @return: None
     * think method that override from realPlayer class for implementing more logic thinking
     * */
    @Override
    public void think() {

        boolean keepThink = true;
        System.out.println(String.format("%s is thinking...", name));

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
