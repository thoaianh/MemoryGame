package main;

import view.MainFrame;

public class Main {
    public static MainFrame mainFrame = new MainFrame();

    public static void main(String[] args) {
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
    }
}
