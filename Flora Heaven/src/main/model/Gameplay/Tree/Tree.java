package main.model.Gameplay.Tree;

// ***
// Author: Vnntnn
// ***

import java.awt.*;
import java.awt.List;
import java.util.ArrayList;
import java.util.*;

public abstract class Tree {
    private String name;
    private double price;
    private int star;
    private Component image;
    private ArrayList<String> hintList;

    public Tree() {
        this("", 0.0, 1, null);
    }

    public Tree(String name, double price, int star, Component image) {
        this.name = name;
        this.price = price;
        this.star = star;
        this.image = image;
        this.hintList = new ArrayList<>();
    }
/*     public Tree(String name, double price, int star, Component image, ArrayList<String> hintList) {
        this.name = name;
        this.price = price;
        this.star = star;
        this.image = image;
        this.hintList = hintList;
    } */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public Component getImage() {
        return image;
    }

    public void setImage(Component image) {
        this.image = image;
    }

    public ArrayList<String> getHintList() {
        return hintList;
    }

    public void setHintList(ArrayList<String> hintList) {
        this.hintList = hintList;
    }

    public void addHintList(String hint){
        this.hintList.add(hint);
    }
}