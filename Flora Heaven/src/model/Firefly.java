package model;

import java.util.Random;
import java.awt.Graphics2D;
import java.awt.Color;

public class Firefly {
    private int x, y;
    private int dx, dy;
    private float glow;
    private Random rand;

    public Firefly(int x, int y) {
        this.x = x;
        this.y = y;
        this.rand = new Random();
        this.dx = rand.nextInt(3) - 1;
        this.dy = rand.nextInt(3) - 1;
        this.glow = rand.nextFloat();
    }

    public void move(int width, int height) {
        x += dx;
        y += dy;

        // Wrap around screen
        if (x < 0) x = width;
        if (x > width) x = 0;
        if (y < 0) y = height;
        if (y > height) y = 0;

        glow += (rand.nextFloat() - 0.5f) * 0.1f;
        glow = Math.max(0.3f, Math.min(1.0f, glow));
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(new Color(255, 255, 100, (int) (glow * 255)));
        g2d.fillOval(x, y, 4, 4);
    }

//    public get
}