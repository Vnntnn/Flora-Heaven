package model;

// ***
// Author: Vnntnn
// ***

import java.io.Serializable;

public class Player implements Serializable{
    private float coins;
    private int day;
    private TreesCollected TreesCollections;

    public Player(){
        coins = 150;
        day = 1;
        TreesCollections = new TreesCollected();
    }

    public Player(float coins, int day, TreesCollected TreesCollections){
        this.coins = coins;
        this.day = day;
        this.TreesCollections = TreesCollections;
    }

    public float getCoins(){
        return coins;
    }

    public int getDay(){
        return day;
    }

    public void setDay(int day){
        this.day = day;
    }

    public void setCoins(float coins){
        this.coins = coins;
    }
}
