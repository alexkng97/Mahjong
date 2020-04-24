package com.jetbrains;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hand {
    ArrayList<Tile> tiles;
    int score;

    public Hand(){
        this.tiles = new ArrayList<>();
    }

    public int getSize(){
        return this.tiles.size();
    }

    public void addToHand(Tile t){
        this.tiles.add(t);
    }

    public void removefromHand(Tile t){
        this.tiles.remove(t);
    }
    public String toString(){
        return this.tiles.toString();

    }

    public void sort(){
        Comparator comparator = new Tile.comparebySuit();
        Collections.sort(this.tiles, comparator);
    }

    public static void main(String[] args) {
        Hand h = new Hand();
        System.out.println(h);
        Tile add = new Tile(Tile.Suit.HONOURS, 1);
        Tile sort = new Tile(Tile.Suit.BAMBOO, 3);
        Tile sort1 = new Tile(Tile.Suit.BAMBOO,7);
        h.addToHand(add);
        System.out.println(h);
        h.removefromHand(add);
        System.out.println(h);
        h.addToHand(add);

        h.addToHand(add);
        h.addToHand(sort1);
        h.addToHand(sort);
        System.out.println(h);
        h.sort();
        System.out.println(h);

    }
}
