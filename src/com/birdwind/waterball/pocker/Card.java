package com.birdwind.waterball.pocker;

import com.birdwind.waterball.pocker.base.enums.RankEnum;
import com.birdwind.waterball.pocker.base.enums.SuitEnum;

public class Card {
    private final SuitEnum suitEnum;

    private final RankEnum rankEnum;

    public Card(SuitEnum suitEnum, RankEnum rankEnum) {
        this.suitEnum = suitEnum;
        this.rankEnum = rankEnum;
    }

    @Override
    public String toString() {
        return suitEnum.getSymbol() + " " + rankEnum.getValue();
    }

    public CompareResultEnums compare(Card card) {
        if (this.suitEnum.compareTo(card.suitEnum) > 0) {
            return CompareResultEnums.BIGGER;
        } else if (this.suitEnum.compareTo(card.suitEnum) < 0) {
            return CompareResultEnums.SMALLER;
        }
        if (this.rankEnum.compareTo(this.rankEnum) > 0) {
            return CompareResultEnums.BIGGER;
        } else if (this.rankEnum.compareTo(this.rankEnum) < 0) {
            return CompareResultEnums.SMALLER;
        }
        return CompareResultEnums.EQUAL;
    }
}
