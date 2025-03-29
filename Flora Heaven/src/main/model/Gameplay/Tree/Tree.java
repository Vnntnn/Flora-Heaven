package main.model.Gameplay.Tree;

// ***
// Author: Vnntnn
// ***

import java.awt.*;

public abstract class Tree {
    private String name;
    private double price;
    private int star;
    private Component image;

    public Tree() {
        this("", 0.0, 1, null);
    }

    public Tree(String name, double price, int star, Component image) {
        this.name = name;
        this.price = price;
        this.star = star;
        this.image = image;
    }

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
}