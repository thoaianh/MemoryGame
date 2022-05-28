package model.menu;


import constant.Constant;

public class QuitHandler  extends Observer {

    public QuitHandler(Subject subject) {
        super.subject = subject;
        this.subject.add(this);
    }


    @Override
    public void update() {
        if(this.subject.getState().equals(Constant.QUIT_COMMAND)){
            System.exit(0);
        }
    }
}
