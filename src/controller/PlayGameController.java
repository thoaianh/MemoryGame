package controller;

import model.Matrix;


import model.State;
import view.content.PlayView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayGameController implements ActionListener {
    private Matrix model;
    private PlayView view;
    private State state;

    public PlayGameController(Matrix model) {
        this.model = model;
        state = new State();
        state.setTargetScore(model.getRow()* model.getCol());
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int x, y;
        String s = e.getActionCommand();
        int k = s.indexOf(" ");
        x = Integer.parseInt(s.substring(0, k));
        y = Integer.parseInt(s.substring(k + 1));

        state = model.calculate(state, x, y);
        view.updateByModelState(state);
    
    }


    public void setView(PlayView view) {
        this.view = view;
    }
}
