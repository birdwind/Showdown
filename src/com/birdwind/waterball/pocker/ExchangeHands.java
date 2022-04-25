package com.birdwind.waterball.pocker;

import com.birdwind.waterball.pocker.base.Player;

public class ExchangeHands {

    private final Player ownerPlayer;

    private Player targetPlayer;

    private int round;

    private Boolean isUsed;

    public ExchangeHands(Player ownerPlayer) {
        this.ownerPlayer = ownerPlayer;
        round = 0;
        isUsed = false;
    }

    public boolean isUsed() {
        return this.isUsed && round != 0;
    }

    public void countDownRound() {
        round++;
        if (round == 4) {
            exchange();
        }
    }

    public void exchange() {
        isUsed = true;
        ownerPlayer.setHand(targetPlayer.getHand());
        targetPlayer.setHand(ownerPlayer.getHand());
    }

    public boolean setTargetPlayer(Player player) {
        if (player == ownerPlayer) {
            System.out.println("The player you choose is yourself!");
        } else {
            if (!player.getExchangeHands().isUsed) {
                targetPlayer = player;
                return true;
            }
            return false;
        }
        return false;
    }
}
