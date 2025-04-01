package main.view.AssetsLoader.books;

import java.awt.*;
import javax.swing.*;
import main.controller.gameplay.BookController;

public class TreesDescriptionsPanel extends JPanel {
    private BookController controller;

    public TreesDescriptionsPanel(BookController controller) {
        this.controller = controller;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (controller.isShowingTrees()) {
            for (int i = 0; i < 4; i++) {
                int index = (controller.getCurrentTreeIndex() + i) % 12;
                if (index < AssetsLoaderBook.Trees.length) {
                    g.drawImage(AssetsLoaderBook.Trees[index],
                            0, 0, getWidth(), getHeight(), null);
                }
            }
        }
    }
}