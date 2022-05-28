package view.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class HelpView extends JPanel {

    private String title;
    private String content;
    private final String FONT_DEFAULT = "VNI-Ariston";

    public HelpView(String title, String content) throws HeadlessException {
        this.title = title;
        this.content = content;
        init();
    }

    /**
     * Create the frame.
     */
    
    public void init() {
        setBounds(10, 10, 800, 300);
        setBorder(new EmptyBorder(5, 5, 5, 5));
       JPanel pnHelp= new JPanel(new BorderLayout());  
       add(pnHelp);
       
        JLabel lblTitle = new JLabel(this.title);
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setBackground(Color.BLUE);
        lblTitle.setFont(new Font(FONT_DEFAULT, Font.PLAIN, 23));
     lblTitle.setBounds(0, 0, 211, 49);
       pnHelp.add(lblTitle, BorderLayout.NORTH);

        JLabel lblContent = new JLabel();
        lblContent.setFont(new Font(FONT_DEFAULT, Font.PLAIN, 20));
        lblContent.setForeground(Color.BLACK);
        lblContent.setText(this.content);
       lblContent.setBounds(0, 0, 200, 85);
        pnHelp.add(lblContent, BorderLayout.WEST);
    }
}
