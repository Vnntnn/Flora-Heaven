package model.Gameplay.Player;

// ***
// Author: Vnntnn
// ***

import model.Gameplay.Tree.TreesCollections.TreesCollections;

import java.io.Serializable;

public class Player implements Serializable{
    private int coins;
    private int day;
    private TreeObtains obtainTrees;

    public Player(){
        coins = 150;
        day = 1;
        obtainTrees = new TreeObtains();
    }

    public Player(int coins, int day, TreeObtains obtainTrees){
        this.coins = coins;
        this.day = day;
        this.obtainTrees = obtainTrees;
    }

    public int getCoins(){
        return coins;
    }

    public int getDay(){
        return day;
    }

    public void setDay(int day){
        this.day = day;
    }

    public void setCoins(int coins){
        this.coins = coins;
    }

    public TreeObtains getObtainTrees(){
        return obtainTrees;
    }

    public void setObtainTrees(TreeObtains obtainTrees){
        this.obtainTrees = obtainTrees;
    }
}