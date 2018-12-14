package blackjack.player;


import blackjack.mainEntry.Player;

public class realPlayer extends Player {

    // instance variable: name, amountBet
    private String name;
    private int amountBet;

    /**
     * @param; name: String, amountBet: int
     * */
    public realPlayer(String name, int amountBet) {
        super(name);
        this.name = name;
        this.amountBet = amountBet;
    }

    /**
     * @param: None
     * @return: None
     * think method that override from realPlayer class for implementing more logic thinking
     * */
    @Override
    public void think() {

        boolean keepThink = true;
        boolean drawCard = true;
        System.out.println(String.format("%s thinking...", name));

        while (keepThink) {
            if (drawCard) {
                System.out.println("realPlayer decide to draw card!");
                drawCard = true;
                keepThink = false;
            }
            else {
                System.out.println("realPlayer decide not to draw card!");
                drawCard = false;
                keepThink = false;
            }
        }
    }

    /**
     * @param: None
     * @return: int
     * get the amount bet
     * */
    public int getAmountBet() {
        return amountBet;
    }

    /**
     * @param: amountBet
     * @return: None
     * get the amount bet
     * */
    public void setAmountBet(int amountBet) {
        this.amountBet = amountBet;
    }

    /**
     * @param: None
     * @return: None
     * print the player name and amount bet
     * */
    public void printPlaceBet() {
        System.out.println(String.format("The %s bet placed: %s", name, getAmountBet()));
    }
}
