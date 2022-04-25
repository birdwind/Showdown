package com.birdwind.waterball.pocker;

import com.birdwind.waterball.pocker.base.Player;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private final Scanner input = new Scanner(System.in);

    @Override
    public void nameSelf(int playerCount) {
        System.out.println("Please input player's name:");
        this.name = input.nextLine();
    }

    @Override
    public Card showCard() {
        System.out.println("You have the following cards in your hand.");

        for (int i = 0; i < hand.size(); i++) {
            System.out.println("Index: " + i + ", Card: " + hand.get(i).toString());
        }

        System.out.println("Please choose a card:(card index)");
        return hand.remove(input.nextInt());
    }
}
