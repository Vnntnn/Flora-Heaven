package main.view.Gamewindow.lobby;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import main.controller.lobby.LobbyController;

public class CreditView {
    private JFrame frame;
    private JPanel mainPanel;
    private Image backgroundImage;
    private List<String> names;
    private Font customFont;
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
                
                // วาดส่วนประกอบอื่นๆ
                drawTitle(g2d);
                drawNames(g2d);
                drawBackButton(g2d);
                
                g2d.dispose();
            }

            private void drawTitle(Graphics2D g2d) {
                g2d.setFont(customFont.deriveFont(100f));
                g2d.setColor(Color.YELLOW);
                String text = "Credits";
                int x = (getWidth() - g2d.getFontMetrics().stringWidth(text)) / 2;
                g2d.drawString(text, x, 100);
            }

            private void drawNames(Graphics2D g2d) {
                if (names != null && !names.isEmpty()) {
                    g2d.setFont(customFont.deriveFont(18f));
                    g2d.setColor(Color.WHITE);
                    
                    int startY = 200;
                    int lineHeight = g2d.getFontMetrics().getHeight() + 10;
                    
                    for (int i = 0; i < names.size(); i++) {
                        String name = names.get(i);
                        int x = (getWidth() - g2d.getFontMetrics().stringWidth(name)) / 2;
                        int y = startY + (i * lineHeight);
                        g2d.drawString(name, x, y);
                    }
                }
            }

            private void drawBackButton(Graphics2D g2d) {
                int buttonWidth = 150;
                int buttonHeight = 50;
                int buttonX = 50;
                int buttonY = 50;
                
                // วาดปุ่ม
                g2d.setColor(Color.YELLOW);
                g2d.fillRoundRect(buttonX, buttonY, buttonWidth, buttonHeight, 10, 10);
                
                // วาดข้อความ
                g2d.setFont(customFont.deriveFont(30f));
                g2d.setColor(Color.BLACK);
                String text = "Back";
                int textX = buttonX + (buttonWidth - g2d.getFontMetrics().stringWidth(text)) / 2;
                int textY = buttonY + (buttonHeight / 2) + (g2d.getFontMetrics().getAscent() / 3);
                g2d.drawString(text, textX, textY);
                
                // กำหนดพื้นที่คลิก
                mainPanel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getX() >= buttonX && e.getX() <= buttonX + buttonWidth &&
                            e.getY() >= buttonY && e.getY() <= buttonY + buttonHeight) {
                            close();
                            if (lobbyController != null) {
                                lobbyController.getView().setVisible(true);
                            }
                        }
                    }
                });
            }
        };

        frame.setContentPane(mainPanel);
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
        frame.setVisible(true);
    }

    public void close() {
        frame.dispose();
    }

    public void toFront() {
        frame.toFront();
    }
}
