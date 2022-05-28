package model.menu;

import constant.Constant;
import main.Main;
import view.content.HelpView;

public class HelpHandler extends Observer {
    private HelpView view;
    private final String TITLE = "How to play?";
    private final String CONTENT = "<html> - Click Start to start playing the game <br>"
    	                      	 + "- Click Quit to exit the game screen <br> <br> </html>";
            
    public HelpHandler(Subject subject) {
        super.subject = subject;
        this.subject.add(this);
    }
    
    @Override
    public void update() {
        if (this.subject.getState().equals(Constant.HELP_COMMAND)) {
            view = new HelpView(this.TITLE, this.CONTENT);
            Main.mainFrame.changePanel(view);
        }
    }
}
