package main.model.Threads;

import java.awt.*;

public class FireflyGlowing extends Firefly {
    private static final float MAX_GLOW = 1.5f;
    private static final int SIZE = 8;

    public FireflyGlowing(int x, int y, int screenWidth, int screenHeight) {
        super(x, y, screenWidth, screenHeight);
        this.glow = Math.min(MAX_GLOW, 1.0f); // จำกัดไม่ให้เกิน 1.0f
    }

    @Override
    protected void adjustGlow() {
        glow = 0.7f + rand.nextFloat() * 0.3f; // สว่างสม่ำเสมอ 0.7-1.0
    }

    @Override
    public void draw(Graphics2D g2d) {
        int alpha = (int) (Math.min(1.0f, glow) * 200); // จำกัด Alpha สูงสุด 200
        g2d.setColor(new Color(255, 255, 180, alpha));
        g2d.fillOval(x - SIZE/2, y - SIZE/2, SIZE, SIZE);

        g2d.setColor(new Color(255, 255, 100, 255));
        g2d.fillOval(x - 1, y - 1, 2, 2);
    }
}