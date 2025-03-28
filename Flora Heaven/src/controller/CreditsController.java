package controller;

import model.Credits.CreditsModel;
import view.Gamewindow.CreditsWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreditsController {
    private CreditsModel model;
    private CreditsWindow view;

    public CreditsController(CreditsModel model, CreditsWindow view) {
        this.model = model;
        this.view = view;

        this.view.setBackButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleBackButton();
            }
        });

        this.view.updateTitleFont(model.getCustomFont());
    }

    private void handleBackButton() {
        view.getFrame().dispose();
    }
}