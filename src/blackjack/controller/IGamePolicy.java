package blackjack.controller;

public interface IGamePolicy {

    boolean isPlayerWin(IPlayer dealer, IPlayer player);
}
