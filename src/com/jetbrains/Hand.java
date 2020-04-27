package com.jetbrains;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hand {
    ArrayList<Tile> tiles;
    int score;
    boolean hasKong;

    public Hand() {
        this.tiles = new ArrayList<>();
    }

    public int getSize() {
        return this.tiles.size();
    }

    public void addToHand(Tile t) {
        this.tiles.add(t);
    }

    public void removefromHand(Tile t) {
        this.tiles.remove(t);
    }

    public String toString() {
        return this.tiles.toString();

    }

    public void sort() {
        Comparator comparator = new Tile.comparebySuit();
        Collections.sort(this.tiles, comparator);
    }

    public int checkForDoubles() {

        int doubleCount = 0;
        for (int i = 0; i < this.tiles.size() - 1; i++) {
            Tile current = this.tiles.get(i);
            System.out.println("Current: " + current);
            int trackDouble = 0;
            for (int j = i + 1; j < this.tiles.size(); j++) {
                System.out.println("Iteration " + j + " " + this.tiles.get(j));
                if (current.compareTo(this.tiles.get(j)) == 0) {
                    trackDouble++;
                    System.out.println("Same Tile Detected");
                    if (trackDouble == 1) {
                        System.out.println("Double");
                        doubleCount++;
                    }else if(trackDouble == 2){
                        System.out.println("Not Double");
                        doubleCount = doubleCount -2;
                    } else if (trackDouble == 3){
                        System.out.println("KONG");
                        this.hasKong = true;
                    }

                }
            }
            System.out.println("-----------------------------");

        }
        return doubleCount;
    }

    public static void main(String[] args) {
        Hand h = new Hand();
        System.out.println(h);
        Tile add = new Tile(Tile.Suit.HONOURS, 1);
        Tile sort = new Tile(Tile.Suit.BAMBOO, 3);
        Tile sort1 = new Tile(Tile.Suit.BAMBOO, 7);
        Tile doub = new Tile(Tile.Suit.BAMBOO, 3);
        Tile doub2 = new Tile(Tile.Suit.HONOURS, 1);
        Tile doub3 = new Tile(Tile.Suit.BAMBOO,3);
        Tile doub4 = new Tile(Tile.Suit.BAMBOO,3);
        Tile doub5 = new Tile(Tile.Suit.BAMBOO,7);

        //Add tiles to hand
        h.addToHand(add);
        System.out.println(h);
        h.removefromHand(add);
        System.out.println(h);
        h.addToHand(add);
        h.addToHand(sort1);
        h.addToHand(sort);
        h.addToHand(doub);
        h.addToHand(doub2);
        h.addToHand(doub3);
        h.addToHand(doub4);
        h.addToHand(doub5);

        System.out.println(h);
        h.sort();
        System.out.println(h);
        System.out.println(h.checkForDoubles());

    }
}
