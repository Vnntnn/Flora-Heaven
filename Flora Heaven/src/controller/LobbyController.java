package controller;

import model.Firefly;

import java.util.ArrayList;

public class LobbyController {
    private ArrayList<Firefly> fireflies;

    public LobbyController() {
        fireflies = new ArrayList<>();
        for (int i = 0; i < 120; i++) {
            fireflies.add(new Firefly((int) (Math.random() * 800), (int) (Math.random() * 600)));
        }
    }

    public ArrayList<Firefly> getFireflies() {
        return fireflies;
    }

    public void updateFireflies(int width, int height) {
        for (Firefly firefly : fireflies) {
            firefly.move(width, height);
        }
    }
}
