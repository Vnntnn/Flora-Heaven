package model;

/*
  @author tipwareeetaokhotsee
*/

import java.awt.*;
import java.util.Random;

public class Firefly {
    private int x, y;
    private int dx, dy;
    private float glow;
    private Random rand = new Random();
    private int screenWidth, screenHeight;

    public Firefly(int x, int y, int screenWidth, int screenHeight) {
        this.x = x;
        this.y = y;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.dx = rand.nextInt(3) - 1;
        this.dy = rand.nextInt(3) - 1;
        this.glow = rand.nextFloat();
    }

    public void move() {
        x += dx;
        y += dy;

        if (x < 0) x = screenWidth;
        if (x > screenWidth) x = 0;
        if (y < 0) y = screenHeight;
        if (y > screenHeight) y = 0;

        glow += (rand.nextFloat() - 0.5f) * 0.1f;
        glow = Math.max(0.3f, Math.min(1.0f, glow));
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(new Color(255, 255, 100, (int) (glow * 255)));
        g2d.fillOval(x, y, 4, 4);
    }
}