package com.birdwind.waterball.pocker;

import com.birdwind.waterball.pocker.base.Player;

import java.util.Random;

public class AIPlayer extends Player {
    private final Random random = new Random();

    @Override
    public void nameSelf(int playerCount) {
        this.name = "AI Player" + playerCount;
    }

    @Override
    public Card showCard() {
        int cardIndex = random.nextInt(hand.size());
        return hand.remove(cardIndex);
    }
}
