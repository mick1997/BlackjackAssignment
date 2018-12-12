package blackjack.player;


import blackjack.mainEntry.Player;

public class HumanPlayer extends Player {

    private String name;

    public HumanPlayer(String name) {
        super(name);
        this.name = name;
    }

    // todo: I have implementing think method, somehow it works
    @Override
    public void think() {

        boolean keepThink = true;
        boolean drawCard = true;
        System.out.println(String.format("%s thinking...", name));

        while (keepThink) {
            if (drawCard) {
                System.out.println("Player decide to draw card!");
                drawCard = true;
                keepThink = false;
            }
            else {
                System.out.println("Player decide not to draw card!");
                drawCard = false;
                keepThink = false;
            }
        }
    }
}
