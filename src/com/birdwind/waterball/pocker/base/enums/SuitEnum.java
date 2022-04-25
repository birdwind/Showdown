package com.birdwind.waterball.pocker.base.enums;

public enum SuitEnum {
    CLUB("♣"), DIAMOND("♦"), HEART("♥"), SPADE("♠");

    private final String symbol;

    SuitEnum(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
