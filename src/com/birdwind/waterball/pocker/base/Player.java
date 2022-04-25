package com.birdwind.waterball.pocker.base;

import com.birdwind.waterball.pocker.Card;
import com.birdwind.waterball.pocker.ExchangeHands;

import java.util.LinkedList;

public abstract class Player {
    private Integer point;

    protected String name;

    protected LinkedList<Card> hand;

    private final ExchangeHands exchangeHands;

    public Player() {
        this.point = 0;
        this.name = "";
        this.hand = new LinkedList<>();
        this.exchangeHands = new ExchangeHands(this);
    }

    public abstract void nameSelf(int playerCount);

    public abstract Card showCard();

    public void drawCard(Card card) {
        this.hand.add(card);
    }

    public String getName() {
        return name;
    }

    public LinkedList<Card> getHand() {
        return hand;
    }

    public void setHand(LinkedList<Card> hand) {
        this.hand = hand;
    }

    public ExchangeHands getExchangeHands() {
        return exchangeHands;
    }

    public void winnerPoint(int point) {
        this.point += point;
    }

    public Integer getPoint() {
        return point;
    }
}
