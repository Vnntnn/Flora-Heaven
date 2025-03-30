package main.controller;

import main.view.Gamewindow.ArcanashopWindow;
import main.view.AssetsLoader.gameplay.Arcanashop.MainQuestPanel;

import java.awt.event.MouseEvent;

public class ArcanashopController {
    private ArcanashopWindow arcanashopWindow;
    private MainQuestPanel mainQuestPanel;

    public ArcanashopController(ArcanashopWindow arcanashopWindow) {
        this.arcanashopWindow = arcanashopWindow;
        this.mainQuestPanel = new MainQuestPanel();
    }

    public void onMainQuestClicked(MouseEvent e) {
    }
}