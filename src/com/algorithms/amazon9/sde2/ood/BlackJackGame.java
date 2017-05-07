package com.algorithms.amazon9.sde2.ood;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created on 25/04/2017
 *
 * @author Ming Li
 */
public class BlackJackGame {

    private DeckOfCards cards;

    public BlackJackGame() {
        this.cards = new DeckOfCards();
    }

    public Card deal() throws Exception {
        return cards.getCard();
    }

    static class DeckOfCards{
        private static final int NUMBER_OF_CARDS = 52;
        private LinkedList<Card> cards;

        public DeckOfCards() {
            this.cards = new LinkedList<>();
            for(int i=1;i<=(NUMBER_OF_CARDS>>2);i++){
                cards.add(new BlackJackCard(i, Suit.CLUB));
                cards.add(new BlackJackCard(i, Suit.SPADE));
                cards.add(new BlackJackCard(i, Suit.DIAMOND));
                cards.add(new BlackJackCard(i, Suit.HEART));
            }

            shuffle();
        }

        public void shuffle(){
            for(int i=0;i<52;i++){
                int random = new Random().nextInt(51) + 1;
                Card tmp = cards.get(random);
                cards.set(random, cards.get(i));
                cards.set(i, tmp);
            }
        }

        public Card getCard() throws Exception {
            if(cards.isEmpty()){
                throw new Exception("No cards in deck");
            }else{
                return cards.pollFirst();
            }
        }

        public boolean isFinished(){
            return cards.isEmpty();
        }
    }

    static class Card {
        private int point;
        private Suit suit;

        public Card(int point, Suit suit) {
            this.point = point;
            this.suit = suit;
        }

        public int getPoint() {
            return point;
        }

        public void setPoint(int point) {
            this.point = point;
        }

        public Suit getSuit() {
            return suit;
        }

        public void setSuit(Suit suit) {
            this.suit = suit;
        }

        @Override
        public String toString() {
            return "Card{" +
                    "point=" + point +
                    ", suit=" + suit +
                    '}';
        }
    }

    static class BlackJackCard extends Card {

        public BlackJackCard(int point, Suit suit) {
            super(point, suit);
        }

        @Override
        public int getPoint() {
            int value = super.getPoint();
            if(value == 1){
                return 11;
            }
            if(value < 10) {
                return value;
            }

            return 10;
        }

        public boolean isAce(){
            return super.getPoint() == 1;
        }

        @Override
        public String toString() {
            return "BlackJackCard{" +
                    "point=" + getPoint() +
                    ", suit=" + getSuit() +
                    ", ace=" + isAce() +
                    '}';
        }
    }

    static enum Suit {
        CLUB, SPADE, DIAMOND, HEART
    }

    public static void main(String[] args) throws Exception {
        BlackJackGame game = new BlackJackGame();
        for(int i=0;i<52;i++){
            System.out.println(game.deal());
        }
    }
}
