package model.menu;

import constant.Constant;

import controller.PlayGameController;
import main.Main;
import model.Matrix;
import view.content.PlayView;

public class PlayGameHandler extends Observer{
    private PlayView view;
    private PlayGameController controller;
    private Matrix model;

    public PlayGameHandler(Subject subject) {
        super.subject = subject;
        this.subject.add(this);
    }


    @Override
    public void update() {
        if (this.subject.getState().equals(Constant.START_COMMAND)) {
            this.model = new Matrix(4,4);
            controller = new PlayGameController(this.model);
            this.view = new PlayView(4,4, controller);
            controller.setView(this.view);

            Main.mainFrame.changePanel(view);
        }
    }
}
