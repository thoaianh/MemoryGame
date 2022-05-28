package controller;

import constant.Constant;
import model.menu.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonController implements ActionListener {
    private Subject subject;

    public ButtonController() {
        init();
    }

    private void init() {
        this.subject = new Subject();
        new HelpHandler(subject);
        new PlayGameHandler(subject);
        new QuitHandler(subject);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case Constant.HELP_COMMAND:
                this.subject.setState(Constant.HELP_COMMAND);
                break;
            case Constant.START_COMMAND:
                this.subject.setState(Constant.START_COMMAND);
                break;
            case Constant.QUIT_COMMAND:
                this.subject.setState(Constant.QUIT_COMMAND);
                break;
            default://noting
        }
        this.subject.execute();
    }
}
