package com.birdwind.waterball.pocker.base.enums;

public enum RankEnum {
    TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9"), TEN("10"), J("J"), Q(
        "Q"), K("K"), A("A");

    private final String value;

    RankEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
