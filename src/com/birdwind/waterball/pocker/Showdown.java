package com.birdwind.waterball.pocker;

import com.birdwind.waterball.pocker.base.Player;

import java.util.*;

public class Showdown {
    private final static int MAX_PLAYER = 4;

    private final static int ROUNDS = 13;

    private final static int WINNER_POINT = 1;

    private final Deck deck = new Deck();

    private final LinkedList<Player> players = new LinkedList<>();

    private Scanner input = new Scanner(System.in);

    /**
     * 開始遊戲
     */
    public void startGame() {
        initPlayer();
        deck.shuffle();
        drawCards();
        for (int i = 1; i <= ROUNDS; i++) {
            turnRound(i);
        }
        showWinner();
    }

    /**
     * 初始化玩家
     */
    private void initPlayer() {
        System.out.println("Do you wanna be a player No(1 ~ 4):");
        int humanPlayer = input.nextInt();
        int aiPlayerCount = 1;
        for (int i = 0; i < MAX_PLAYER; i++) {
            Player player;
            if ((i + 1) == humanPlayer) {
                player = new HumanPlayer();
                player.nameSelf(0);
            } else {
                player = new AIPlayer();
                player.nameSelf(aiPlayerCount++);
            }
            players.add(player);
        }
    }

    /**
     * 抽牌
     */
    private void drawCards() {
        for (int i = 0; i < MAX_PLAYER; i++) {
            for (int j = 0; j < 13; j++) {
                // print("player: " + players.get(i).getName() + ", 次數: " + j + ", 卡片: (" + (i + j * MAX_PLAYER) + ")"
                // + deck.getCard(i + j * MAX_PLAYER));
                players.get(i).drawCard(deck.getCard(i + j * MAX_PLAYER));
            }
        }
    }

    private void turnRound(int round) {
        print("====== Round " + round + " ======");
        List<Card> showCardList = new ArrayList<>();
        Card biggerCard = null;
        Player biggerPlayer = null;
        for (Player player : players) {
            useExchange(player);
            Card showCard = player.showCard();
            showCardList.add(showCard);

            if (biggerCard == null) {
                biggerCard = showCard;
                biggerPlayer = player;
            }

            if (biggerCard.compare(showCard) == CompareResultEnums.BIGGER) {
                biggerCard = showCard;
                biggerPlayer = player;
            }
        }

        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            Card card = showCardList.get(i);
            System.out.println("This round " + player.getName() + " use " + card.toString());
        }
        System.out.println("The Winner is " + biggerPlayer + "(" + biggerCard + ")");
        if (biggerPlayer != null) {
            biggerPlayer.winnerPoint(WINNER_POINT);
        }
    }

    private void useExchange(Player player) {
        ExchangeHands playerExchangeHands = player.getExchangeHands();
        if (playerExchangeHands.isUsed()) {
            playerExchangeHands.countDownRound();
        } else {
            if (player instanceof HumanPlayer) {
                System.out.println("Do you wanna to use 'Exchange Hand'?(y: yes, n: no)");
                String use = input.nextLine();
                if (use.toLowerCase(Locale.ROOT).equals("y") || use.toLowerCase(Locale.ROOT).equals("yes")) {
                    while (playerExchangeHands.setTargetPlayer(players.get(input.nextInt()))) {
                        System.out.println("Choose a player to exchange hand (player index):");
                    }
                    playerExchangeHands.countDownRound();
                }
            }

        }
    }

    private void showWinner() {
        players.sort(Comparator.comparingInt(Player::getPoint));
        System.out.println("The winner is " + players.get(0).getName());
    }

    private void printPlayerCards() {
        for (Player player : players) {
            System.out.println(player.getName());
            for (Card card : player.getHand()) {
                System.out.println(card.toString());
            }
        }
    }

    private void print(Object object) {
        System.out.println(object.toString());
    }
}
