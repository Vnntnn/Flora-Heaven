package main.view.Gamewindow.lobby;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import main.controller.lobby.LobbyController;

public class CreditView {
    private JFrame frame;
    private JPanel mainPanel;
    private Image backgroundImage;
    private List<String> names;
    private Font customFont;
    private boolean isVisible = false;
    private LobbyController lobbyController;

    public CreditView(Font customFont, LobbyController lobbyController) {
        this.customFont = customFont;
        this.lobbyController = lobbyController;
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame("Flora Heaven");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1290, 755);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                
                // วาดพื้นหลัง
                if (backgroundImage != null) {
                    g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
                }
                
                // วาดข้อความ Title
                g2d.setFont(customFont.deriveFont(100f));
                g2d.setColor(Color.YELLOW);
                drawCenteredString(g2d, "Credits", getWidth(), 5);
                
                // วาดรายชื่อ
                if (names != null) {
                    g2d.setFont(customFont.deriveFont(18f));
                    g2d.setColor(Color.WHITE);
                    drawNames(g2d);
                }
                
                // วาดปุ่ม Back
                drawButton(g2d);
                
                g2d.dispose();
            }

            private void drawCenteredString(Graphics2D g2d, String text, int width, int y) {
                FontMetrics fm = g2d.getFontMetrics();
                int x = (width - fm.stringWidth(text)) / 2;
                g2d.drawString(text, x, y + fm.getAscent());
            }

            private void drawNames(Graphics2D g2d) {
                FontMetrics fm = g2d.getFontMetrics();
                int startY = 195;
                int lineHeight = fm.getHeight() + 18;
                
                for (int i = 0; i < names.size(); i++) {
                    String name = names.get(i);
                    int x = (getWidth() - fm.stringWidth(name)) / 2;
                    int y = startY + (i * lineHeight);
                    g2d.drawString(name, x, y);
                }
            }

            private void drawButton(Graphics2D g2d) {
                int buttonWidth = 100;
                int buttonHeight = 50;
                int buttonX = 50;
                int buttonY = 40;
                
                // วาดพื้นหลังปุ่ม
                g2d.setColor(Color.YELLOW);
                g2d.fillRect(buttonX, buttonY, buttonWidth, buttonHeight);
                
                // วาดข้อความปุ่ม
                g2d.setFont(customFont.deriveFont(30f));
                g2d.setColor(Color.BLACK);
                FontMetrics fm = g2d.getFontMetrics();
                int textX = buttonX + (buttonWidth - fm.stringWidth("Back")) / 2;
                int textY = buttonY + ((buttonHeight - fm.getHeight()) / 2) + fm.getAscent();
                g2d.drawString("Back", textX, textY);
            }
        };

        mainPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkButtonClick(evt.getX(), evt.getY());
            }
        });

        frame.setContentPane(mainPanel);
    }

    private void checkButtonClick(int x, int y) {
        // ตรวจสอบว่าคลิกในพื้นที่ปุ่มหรือไม่
        if (x >= 50 && x <= 200 && y >= 20 && y <= 70) {
            close();
            if (lobbyController != null) {
                EventQueue.invokeLater(() -> new LobbyController());
            }
        }
    }

    public void setBackgroundImage(Image background) {
        this.backgroundImage = background;
        mainPanel.repaint();
    }

    public void setNames(List<String> names) {
        this.names = names;
        mainPanel.repaint();
    }

    public void show() {
        isVisible = true;
        frame.setVisible(true);
    }

    public void close() {
        isVisible = false;
        frame.dispose();
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean b) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setVisible'");
    }

    public void toFront() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toFront'");
    }
}