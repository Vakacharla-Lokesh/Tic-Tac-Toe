import javax.swing.*;
import java.awt.*;
public class WelcomeGUI extends JFrame{
    JLabel welcome, img;
    JButton next;
    WelcomeGUI(){
        setLayout(new GridLayout(3, 1));
        setTitle("Tic-Tac-Toe!");
        setSize(350, 350);
        img = new JLabel("filler");
        add(img);
        welcome = new JLabel("Welcome!!");
        add(welcome);
        next = new JButton("Next");
        next.addActionListener((ae) ->{
            setVisible(false);
            new GameGUI();
        });
        add(next);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
