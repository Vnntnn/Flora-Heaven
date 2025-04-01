package main.model.Threads;

import java.awt.*;
import java.util.Random;

public class Firefly {
    protected int x, y;
    protected int dx, dy;
    protected float glow; // ค่าความสว่าง 0.0f ถึง 1.0f
    protected Random rand;
    protected int screenWidth, screenHeight;

    public Firefly(int x, int y, int screenWidth, int screenHeight) {
        this.x = x;
        this.y = y;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.rand = new Random();
        this.dx = rand.nextInt(3) - 1;
        this.dy = rand.nextInt(3) - 1;
        this.glow = Math.min(1.0f, Math.max(0.0f, rand.nextFloat())); // จำกัดค่า glow 0-1
    }

    public void move() {
        x += dx;
        y += dy;

        if (x < 0) x = screenWidth;
        if (x > screenWidth) x = 0;
        if (y < 0) y = screenHeight;
        if (y > screenHeight) y = 0;

        adjustGlow();
    }

    protected void adjustGlow() {
        glow += (rand.nextFloat() - 0.5f) * 0.1f;
        glow = Math.max(0.0f, Math.min(1.0f, glow)); // จำกัดค่า glow 0-1
    }

    public void draw(Graphics2D g2d) {
        int alpha = (int) (Math.min(1.0f, Math.max(0.0f, glow)) * 255); // จำกัด Alpha 0-255
        g2d.setColor(new Color(255, 255, 100, alpha));
        g2d.fillOval(x, y, 4, 4);
    }
}