package com.jetbrains;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Tile> deck;

    public Deck() {
       this.deck = createDeck();
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

    public ArrayList<Tile> createDeck(){
        ArrayList<Tile> deck = new ArrayList<>(144);
        for (Tile.Suit suit : Tile.Suit.values()) {
            //iterate through suit
            if (suit.equals(Tile.Suit.FLOWERS) || (suit.equals(Tile.Suit.SEASONS))) {
                //create flower
                for (int i = 1; i < 5; i++) {
                    Tile t = new Tile(suit, i);
                    deck.add(t);
                }
            } else {
                for (int j = 0; j < 4; j++) {
                    //create 4 sets
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
        return deck;
    }

    public Tile deal(){
        Tile output = this.deck.get(0);
        this.deck.remove(0);

        return output;
    }

    public Tile dealFromBottom(){
        Tile output = this.deck.get(this.deck.size()-1);
        this.deck.remove(this.deck.size()-1);

        return output;
    }

    public static void main(String[] args) {
        Deck d = new Deck();

        System.out.println(d.getSize());
        d.shuffle();
        System.out.println(d);
        Tile out = d.deal();


        System.out.println(d);
        System.out.println(d.getSize());

        Tile bottom = d.dealFromBottom();
        System.out.println(bottom);
        System.out.println();
    }
}


