package view.trees;

// ***
// Author: Vnntnn
// ***

import javax.swing.*;
import java.awt.*;

public class LunacryptaPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AssetsLoaderTrees.lunacrypta, 0, 0, getWidth(), getHeight(), this);
    }
}
