package com.birdwind.waterball.pocker;

import com.birdwind.waterball.pocker.base.enums.RankEnum;
import com.birdwind.waterball.pocker.base.enums.SuitEnum;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private final ArrayList<Card> cards = new ArrayList<>();

    public Deck() {
        for (SuitEnum suitEnum : SuitEnum.values()) {
            for (RankEnum rankEnum : RankEnum.values()) {
                cards.add(new Card(suitEnum, rankEnum));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card getCard(int position) {
        return cards.get(position);
    }
}
