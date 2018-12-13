package blackjack.controller;

public interface IGamePolicy {

    // isPlayerWin method: check either dealer or player win the game
    boolean isPlayerWin(IPlayer dealer, IPlayer player);
}
