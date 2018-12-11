package blackjack.mainEntry;

import blackjack.controller.IGamePolicy;
import blackjack.controller.IPlayer;

public class GamePolicy implements IGamePolicy {

    @Override
    public boolean isPlayerWin(IPlayer dealer, IPlayer player) {
        if (dealer.isBusted()) {
            if(player.isBusted()) {
                return false;
            }
            else {
                return true;
            }
        }
        else {
            if(player.isBusted()) {
                return false;
            } else {
                return dealer.getCardSum() < player.getCardSum();
            }
        }
    }
}
