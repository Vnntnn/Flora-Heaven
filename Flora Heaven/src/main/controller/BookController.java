package main.controller;

import main.model.Player.Player;
import main.model.sound.bgSound;
import main.view.Gamewindow.BookWindow;
import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class BookController implements WindowFocusListener {
    private Player player;
    private BookWindow view;
    private int currentTreeIndex = 0;
    private int currentCombineIndex = 0;
    private boolean showingTrees = true;
    private boolean isAnimating = false;
    private boolean isNextAnimation = false;

    public BookController(Player player) {
        this.player = player;
        this.view = new BookWindow(this);
        view.addWindowFocusListener(this);

    }

    public void nextPage() {
        if (isAnimating) return;

        isAnimating = true;
        isNextAnimation = true;
        startAnimation();
    }

    public void prevPage() {
        if (isAnimating) return;

        isAnimating = true;
        isNextAnimation = false;
        startAnimation();
    }

    private void startAnimation() {
        view.showSwappingAnimation(isNextAnimation);

        // ใช้ Timer ที่มีความถี่สูงขึ้นสำหรับ animation
        Timer timer = new Timer(50, e -> {
            if (isNextAnimation) {
                changeToNextPage();
            } else {
                changeToPrevPage();
            }
            isAnimating = false;
            ((Timer)e.getSource()).stop();
        });
        timer.setRepeats(false);
        timer.start();
    }

    private void changeToNextPage() {
        if (showingTrees) {
            currentTreeIndex = (currentTreeIndex + 4) % 12;
            if (currentTreeIndex == 0) showingTrees = false;
        } else {
            currentCombineIndex = (currentCombineIndex + 1) % 6;
            if (currentCombineIndex == 0) showingTrees = true;
        }
        updateView();
    }

    private void changeToPrevPage() {
        if (showingTrees) {
            currentTreeIndex = (currentTreeIndex - 4 + 12) % 12;
            if (currentTreeIndex == 8) {
                showingTrees = false;
                currentCombineIndex = 5;
            }
        } else {
            currentCombineIndex = (currentCombineIndex - 1 + 6) % 6;
            if (currentCombineIndex == 5) {
                showingTrees = true;
                currentTreeIndex = 8;
            }
        }
        updateView();
    }

    private void updateView() {
        if (view != null) {
            view.repaint();
        }
    }

    public int getCurrentTreeIndex() {
        return currentTreeIndex;
    }

    public int getCurrentCombineIndex() {
        return currentCombineIndex;
    }

    public boolean isShowingTrees() {
        return showingTrees;
    }

    public static void main(String[] args) {
        Player player = new Player();
        BookController controller = new BookController(player);
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {

    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        view.dispose();
    }
}