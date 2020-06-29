package com.jetbrains;

import java.util.ArrayList;

public class Player {
    private Hand hand;
    private int id;
    private Hand sideHand;
    private String direction;
    private boolean master;

    public Player(int id, Boolean master){
        this.id = id;
        this.hand = new Hand();
        this.sideHand = new Hand();
        this.master = master;
    }

    public Hand getHand(){
            return this.hand;

    }

    public Hand getSideHand(){
        return this.sideHand;
    }

    public boolean addToSideHand(Tile tile){
        int beforeSize = this.sideHand.getSize();
        this.sideHand.addToHand(tile);
        int afterSize = this.sideHand.getSize();

        if(afterSize > beforeSize){
            return true;
        }else{
            return false;
        }
    }

    public void setDirection(int value){
        this.direction = Tile.convertHonour(value);
    }

    public String toString(){
        if(this.master){
            return "MASTER: Player " +
                    "" + this.id;
        }else {
            return "Player " + this.id;
        }
    }


    public static void main(String[] args) {
        Player p = new Player(1, true);
        Tile t = new Tile(Tile.Suit.BAMBOO,1);
        System.out.println(p);
        System.out.println(p.sideHand.getSize());
        System.out.println(p.addToSideHand(t));
        System.out.println(p.sideHand.getSize());


    }
}
