package main.view.AssetsLoader.books;

import java.awt.*;
import javax.swing.*;
import main.controller.BookController;

public class combinePanel extends JPanel {
    private BookController controller;

    public combinePanel(BookController controller) {
        this.controller = controller;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!controller.isShowingTrees()) {
            int index = controller.getCurrentCombineIndex();
            if (index < AssetsLoaderBook.combinedTrees.length) {
                g.drawImage(AssetsLoaderBook.combinedTrees[index],
                        0, 0, getWidth(), getHeight(), null);
            }
        }
    }
}