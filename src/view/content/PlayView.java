package view.content;

import controller.PlayGameController;

import main.Main;
import model.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayView extends JPanel {
    private JButton matrixBt[][];
    private PlayGameController controller;
    private State state;
    private Timer timer;
    private JProgressBar progressTime;
    private JPanel grid;
    Timer timer2;
    private int time = 0, maxTime = 100;
    boolean start = false;

    public PlayView(int m, int n, PlayGameController controller) {
        this.controller = controller;
        init(m, n);
        initProgressTime();

    }

    public void init(int m, int n) {
        maxTime = maxTime;
        setLayout(new BorderLayout());
        progressTime = new JProgressBar(0, maxTime);
        progressTime.setValue(maxTime);
        progressTime.setForeground(Color.orange);
        add(progressTime, BorderLayout.NORTH);
        JPanel pnPlayArea = new JPanel();
        JPanel grid = createGraphicsPanel(m, n);
        pnPlayArea.add(grid);
        pnPlayArea.setBounds(grid.getX(), grid.getY(), grid.getWidth(), grid.getHeight());
        add(pnPlayArea, BorderLayout.CENTER);
        setSize(n * 300, m * 300);
    }

    public JPanel createGraphicsPanel(int m, int n) {
        grid = new JPanel();
        grid.setLayout(new GridLayout(m, n));
        matrixBt  = new JButton[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                matrixBt[i][j] = new JButton();
                grid.add(matrixBt[i][j]);
                matrixBt[i][j].setActionCommand(i + " " + j);
                matrixBt[i][j].addActionListener(this.controller);
                matrixBt[i][j].setBackground(Color.black);
                matrixBt[i][j].setIcon(getIcon(0));
            }
        grid.setSize(n * 120, m * 170 + 90);
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.gray);
        panel.add(grid);
        return panel;
    }

    private Icon getIcon(int index) {
        int width = 120, height = 120;
        Image image = new ImageIcon(getClass().getResource("/icon/icon" + index + ".png")).getImage();
        Icon icon = new ImageIcon(image.getScaledInstance(width, height, image.SCALE_SMOOTH));
        return icon;
    }

    /*
     * nh???n state t??? model g???i qua =>> update l???i giao di???n theo result c???a state
     * d??ng timer ????? delay hi???n th??? ???nh
     */
    public void updateByModelState(State s) {
        if(!start){
            timer2.start();
        }
        this.state = s;
        if (s.getResult() == null) {
            matrixBt[this.state.getStepOneX()][this.state.getStepOneY()].setIcon(getIcon(this.state.getImageStep1()));
            return;
        }

        matrixBt[this.state.getStepTwoX()][this.state.getStepTwoY()].setIcon(getIcon(this.state.getImageStep2()));
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                matrixBt[state.getStepOneX()][state.getStepOneY()].setIcon(getIcon(state.getIndex()));
                matrixBt[state.getStepTwoX()][state.getStepTwoY()].setIcon(getIcon(state.getIndex()));
                state.clear();
                if(state.getCurrentScore() == state.getTargetScore()){
                    showDialogNewGame("Game k???t th??c.\n" +
                            "B???n c?? mu???n ch??i l???i kh??ng?", "Th??ng b??o");
                }
                timer.stop();
            }
        });
        timer.start();
    }

    public void initProgressTime() {
        timer2 = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                time++;
                progressTime.setValue(maxTime - time);
                if (maxTime == time) {
                    timer2.stop();
                    showDialogNewGame("H???t th???i gian.\n" +
                            "B???n c?? mu???n ch??i l???i kh??ng?", "Th??ng b??o");
                }
            }
        });
    }
    

    public void showDialogNewGame(String message, String title) {
        int select = JOptionPane.showOptionDialog(null, message, title,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                null, null);
        if (select == 0) {
            Main.mainFrame.getBtnStart().doClick();
        } else {
            System.exit(0);
        }
    }

}