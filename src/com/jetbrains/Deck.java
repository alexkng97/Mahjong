package com.jetbrains;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Tile> deck;

    public Deck() {
        this.deck = new ArrayList<>(144);
        for (Tile.Suit suit : Tile.Suit.values()) {
            if (suit.equals(Tile.Suit.FLOWERS) || (suit.equals(Tile.Suit.SEASONS))) {
                //create flower
                for (int i = 1; i < 5; i++) {
                    Tile t = new Tile(suit, i);
                    deck.add(t);
                }
            } else {
                for (int j = 0; j < 4; j++) {
                    if (suit.equals(Tile.Suit.HONOURS)) {
                        //create honour
                        for (int i = 1; i < 5; i++) {
                            Tile t = new Tile(suit, i);
                            deck.add(t);
                        }
                    } else if (suit.equals(Tile.Suit.DRAGONS)) {
                        for (int i = 1; i < 4; i++) {
                            Tile t = new Tile(suit, i);
                            deck.add(t);
                        }
                    } else {
                        for (int i = 1; i < 10; i++) {
                            Tile t = new Tile(suit, i);
                            deck.add(t);
                        }

                    }
                }
            }

        }
    }

    public void shuffle(){
        Collections.shuffle(this.deck);
    }

    public int getSize() {
        return this.deck.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.deck.size(); i++) {
            sb.append(deck.get(i));
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Deck d = new Deck();
        //System.out.println(d);
        System.out.println(d.getSize());
        d.shuffle();
        System.out.println(d);
    }
}


