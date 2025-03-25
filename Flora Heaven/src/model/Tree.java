package model;

// ***
// Author: Vnntnn
// ***

public abstract class Tree {
    private String name;
    private double price;
    private int star;

    public Tree() {
        this("", 0.0, 1);
    }

    public Tree(String name, double price, int star) {
        this.name = name;
        this.price = price;
        this.star = star;
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
}
