package com.jetbrains;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Tile {
    public enum Suit {CHARACTERS, BAMBOO, DOTS, HONOURS, DRAGONS, FLOWERS, SEASONS}

    private int value;

    private final Suit suit;


    public Tile(Suit suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public int getValue() {
        return this.value;
    }


    public String toString() {

        if (this.suit == Suit.HONOURS) {
            return convertHonour(this.value);
        } else if (this.suit == Suit.DRAGONS) {
            return convertDragon(this.value);
        }else {
            return (this.value + " " + this.suit);
        }
    }

    public static String convertHonour(int value) {
        switch (value) {
            case 1:
                return "EAST";
            case 2:
                return "SOUTH";
            case 3:
                return "WEST";
            case 4:
                return "NORTH";
            default:
                return "invalid";
        }

    }

    public String convertDragon(int value){
        switch(value){
            case 1:
                return "SWORD";
            case 2:
                return "GREENIE";
            case 3:
                return "MIRROR";
            default:
                return "invalid";
        }
    }

    public int compareTo(Tile other) {

        if (this.suit == other.suit) {
            if (this.value == other.value) {
                return 0;
            } else if (this.value > other.value) {
                return 1;
            } else {
                return -1;
            }
        } else if (this.suit.ordinal() > other.suit.ordinal()) {
            return 1;
        } else {
            return -1;
        }


    }

    public static class comparebySuit implements Comparator<Tile> {
        @Override
        public int compare(Tile tile, Tile t1) {
            return tile.compareTo(t1);
        }
    }


    public static void main(String[] args) {
        Tile t = new Tile(Suit.HONOURS, 1);
        Tile t1 = new Tile(Suit.CHARACTERS, 9);
        Tile t2 = new Tile(Suit.CHARACTERS, 7);
        ArrayList<Tile> tiles = new ArrayList<>();

        tiles.add(t);
        tiles.add(t1);
        tiles.add(t2);

        System.out.println(tiles.toString());

        Comparator comparator = new comparebySuit();
        Collections.sort(tiles, comparator);

        System.out.println(tiles.toString());
    }


}
