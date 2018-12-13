package blackjack.controller;

import blackjack.card.Card;

public class GameController {

    // Dependencies from external world
    // instance variable: gamePolicy, cardProvider, dealer, players, gameOver
    private IGamePolicy gamePolicy;
    private ICardProvider cardProvider;
    private IPlayer dealer;
    private IPlayer[] players;
    private boolean gameOver = false;

    /**
     * @param: gamePolicy: IGamePolicy, cardProvider: ICardProvider, dealer: IPlayer, players: IPlayer[]
     * */
    public GameController(IGamePolicy gamePolicy, ICardProvider cardProvider, IPlayer dealer, IPlayer[] players) {
        this.gamePolicy = gamePolicy;
        this.cardProvider = cardProvider;
        this.dealer = dealer;
        this.players = players;
    }

    /**
     * @param: None
     * @return: None
     * run the application of the blackjack card game with each round and do perform and examine
     * */
    public void run() {
        int rounds = 1;
        System.out.println(String.format("\nRound-%d", rounds));
        dealInitialHands();
        examineStatus();

        //int loop = 0; the loop use for determining to stop gameOver
        while (!gameOver) {
            rounds += 1;
            System.out.println(String.format("\nRound-%d", rounds));
            performRound();
            examineStatus();
        }
        System.out.println("\n");
        allocateCredits();
    }

    /**
     * @param: None
     * @return: None
     * for initial round, each players and dealer get 2 cards
     * */
    private void dealInitialHands() {

        dealer.acceptCards(cardProvider.getNext(2));

        for (IPlayer player : players) {
            Card[] twoCards = cardProvider.getNext(2);
            player.acceptCards(twoCards);
        }
    }

    /**
     * @param: None
     * @return: None
     * dealer starts to think about the game, then if dealer is not done, continue draw card; for each player, player
     * can either draw card or think something else
     * */
    private void performRound() {

        dealer.think();

        if (!dealer.isDone()) {
            dealer.acceptCards(cardProvider.getNext(1));
        }
        for (IPlayer player : players) {
            if (!player.isDone()) {
                player.think();
            }
            if (!player.isDone()) {
                player.acceptCards(cardProvider.getNext(1));
            }
        }
    }

    /**
     * @param: None
     * @return: None
     * check if dealer or player is blackjack or busted
     * */
    private void examineStatus() {

        boolean dealerIsDone = dealer.isBlackJack() || dealer.isBusted();
        boolean allPlayersDone = true;

        for (IPlayer player : players) {
            if (!player.isDone()) {
                allPlayersDone = false;
                break;
            }
        }
        if (dealerIsDone || allPlayersDone) {
            gameOver = true;
        }
    }

    /**
     * @param: None
     * @return: None
     * add credit to either dealer or player if win the game
     * */
    private void allocateCredits() {

        for (IPlayer player : players) {
            boolean playerWin = gamePolicy.isPlayerWin(dealer, player);
            int amount = player.getBet();
            if (playerWin) {
                player.addCredit(amount);
                dealer.addCredit(-amount);
            }
            else {
                player.addCredit(-amount);
                dealer.addCredit(amount);
            }
        }
    }

}
