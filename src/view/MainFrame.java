package view;

import controller.ButtonController;



import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private JPanel contentPane;
    private final String LBL_TITLE = "Memory Game";

    private JButton btnStart;
    private ActionListener actionListener = new ButtonController();

    /**
     * Create the frame.
     */
    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 550);
        init();
    }

    public JPanel init() {
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbTitle = new JLabel(LBL_TITLE);
        lbTitle.setForeground(new Color(255, 0, 0));
        lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitle.setFont(new Font("Broadway", Font.PLAIN, 55));
        lbTitle.setBounds(10, 0, 964, 84);
        contentPane.add(lbTitle);

        btnStart = new JButton("Start");
        btnStart.setHorizontalAlignment(SwingConstants.LEFT);
        btnStart.addActionListener(actionListener);
        btnStart.setForeground(new Color(0, 0, 128));
        btnStart.setFont(new Font("Dialog", Font.BOLD, 34));
        btnStart.setBounds(61, 144, 227, 54);
        clearBtn(btnStart);

        contentPane.add(btnStart);

        JButton btnHelp = new JButton("Help");
        btnHelp.addActionListener(actionListener);
        btnHelp.setHorizontalAlignment(SwingConstants.LEFT);
        btnHelp.setForeground(new Color(0, 0, 128));
        btnHelp.setFont(new Font("Dialog", Font.BOLD, 34));
        btnHelp.setBounds(61, 343, 227, 58);
        clearBtn(btnHelp);
        contentPane.add(btnHelp);
        JButton btnSetting = new JButton("Quit");
        btnSetting.addActionListener(actionListener);
        btnSetting.setHorizontalAlignment(SwingConstants.LEFT);
        btnSetting.setForeground(new Color(0, 0, 128));
        btnSetting.setFont(new Font("Dialog", Font.BOLD, 34));
        btnSetting.setBounds(61, 271, 227, 58);

        clearBtn(btnSetting);

        contentPane.add(btnSetting);

        JLabel lbBackGround = new JLabel();
        Image image = new ImageIcon(getClass().getResource("/icon/background.png")).getImage();
        Icon icon = new ImageIcon(image.getScaledInstance(1000, 750, image.SCALE_SMOOTH));
        lbBackGround.setIcon(icon);

        lbBackGround.setIcon(icon);
        lbBackGround.setBounds(35, 11, 978, 744);
        contentPane.add(lbBackGround);
        return contentPane;
    }

    //Chỉnh button trong suốt
    public JButton clearBtn(JButton btn) {
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setFocusPainted(false);
        return btn;
    }

    public void changePanel(JPanel panel) {
        getContentPane().removeAll();
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().doLayout();
        this.setVisible(true);
        this.setSize(panel.getSize());
        setResizable(false);
        update(getGraphics());
    }

    public JButton getBtnStart() {
        return btnStart;
    }
}
