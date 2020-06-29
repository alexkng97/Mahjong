package com.jetbrains;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Table {

    private ArrayList<Player> players;
    private Deck deck;

    public Table() {
        this.deck = new Deck();
        this.players = new ArrayList<>(4);
        boolean master;
        for (int i = 1; i < 5; i++) {
            if (i == 1) {
                master = true;
            } else {
                master = false;
            }
            Player p = new Player(i, master);
            this.players.add(p);
        }
    }

    public int[] dice() {
        int[] dices = new int[3];

        for (int i = 0; i < 3; i++) {
            Random random = new Random();
            dices[i] = random.nextInt(6-1)+1;

        }
        return dices;

    }

    public static void main(String[] args) {
        Table t = new Table();
        System.out.println(t.players);
        System.out.println(Arrays.toString(t.dice()));

    }


}
