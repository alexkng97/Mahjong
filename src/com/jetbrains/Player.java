package com.jetbrains;

import java.util.ArrayList;

public class Player {
    private Hand hand;
    private int id;
    private Hand side;
    private String direction;
    private boolean master;

    public Player(int id, Boolean master){
        this.id = id;
        this.hand = new Hand();
        this.side = new Hand();
        this.master = master;
    }

    public Hand getHand(){
            return this.hand;

    }

    public void setDirection(int value){
        this.direction = Tile.convertHonour(value);
    }

    public String toString(){
        if(this.master){
            return "MASTER: Player " + this.id;
        }else {
            return "Player " + this.id;
        }
    }


    public static void main(String[] args) {
        Player p = new Player(1, true);

        System.out.println(p);
    }
}
