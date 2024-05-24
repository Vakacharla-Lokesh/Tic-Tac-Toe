import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI extends JFrame implements ActionListener{
    JPanel top, mid, bottom;
    JLabel pl1, pl2, sc1, sc2, status;
    int score_1 = 0, score_2 = 0;
    JButton[] buttons = new JButton[9];
    boolean first_player = true;
    boolean game_win = false;
    JButton reset, back;
    
    GameGUI(){
        setTitle("Game Time");
        setSize(400, 400);
        setLayout(new BorderLayout(10,10));

        // ADDING SCORES OF PLAYERS TO TOP OF FRAME
        top = new JPanel();
        top.setSize(350, 100);
        top.setLayout(new GridLayout(2, 2));
        pl1 = new JLabel("Player X:");
        top.add(pl1);
        sc1 = new JLabel(String.valueOf(score_1));
        top.add(sc1);
        pl2 = new JLabel("Player O:");
        top.add(pl2);
        sc2 = new JLabel(String.valueOf(score_2));
        top.add(sc2);

        add(top, BorderLayout.NORTH);

        // ADDING GRID TO THE FRAME
        mid = new JPanel();
        mid.setLayout(new GridLayout(3,3));
        for(int i = 0; i<9; i++){
            buttons[i] = new JButton();
            mid.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 30));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        add(mid, BorderLayout.CENTER);

        // BOTTOM LAYER OF THE FRAME
        bottom = new JPanel();
        bottom.setLayout(new GridLayout(1, 3));
        
        back = new JButton("Back");
        back.addActionListener((ae) ->{
            this.setVisible(false);
            new WelcomeGUI();
        });
        
        status = new JLabel();

        reset = new JButton("Reset");
        reset.addActionListener((ae) ->{
            for(int i = 0; i<9; i++){
                buttons[i].setBackground(null);
                buttons[i].setEnabled(true);
                buttons[i].setText("");
                first_player = true;
                game_win = false;
            }
        });
        
        bottom.add(back);
        bottom.add(status);
        bottom.add(reset);

        add(bottom, BorderLayout.SOUTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i<9; i++){
            if(e.getSource() == buttons[i]){
                if(first_player){
                    if(buttons[i].getText() == ""){
                        buttons[i].setText("X");
                        buttons[i].setForeground(new Color(255, 0, 0));
                        first_player = false;
                        check();
                    }
                }
                else{
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        first_player = true;
                        check();
                    }    
                }
            }
        }
    }
    private void check() {
        // CHECKING FOR X WINS
        if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X")){
            xWins(0,1,2);
        }
        if((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X")){
            xWins(3,4,5);
        }
        if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X")){
            xWins(6,7,8);
        }
        if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X")){
            xWins(0,3,6);
        }
        if((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X")){
            xWins(1,4,7);
        }
        if((buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X")){
            xWins(2,5,8);
        }
        if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X")){
            xWins(0,4,8);
        }
        if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X")){
            xWins(2,4,6);
        }

        // CHECKING FOR O WINS
        if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O")){
            oWins(0,1,2);
        }
        if((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O")){
            oWins(3,4,5);
        }
        if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O")){
            oWins(6,7,8);
        }
        if((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O")){
            oWins(0,3,6);
        }
        if((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O")){
            oWins(1,4,7);
        }
        if((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O")){
            oWins(2,5,8);
        }
        if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O")){
            oWins(0,4,8);
        }
        if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O")){
            oWins(2,4,6);
        }
    }
    private void xWins(int i, int j, int k) {
        buttons[i].setBackground(Color.GREEN);
        buttons[j].setBackground(Color.GREEN);
        buttons[k].setBackground(Color.GREEN);
        game_win = true;

        for(int z = 0; z<9; z++){
            buttons[z].setEnabled(false);
        }
        score_1++;
        sc1.setText(String.valueOf(score_1));
        status.setText("X Wins");
    }
    private void oWins(int i, int j, int k) {
        buttons[i].setBackground(Color.GREEN);
        buttons[j].setBackground(Color.GREEN);
        buttons[k].setBackground(Color.GREEN);
        game_win = true;

        for(int z = 0; z<9; z++){
            buttons[z].setEnabled(false);
        }
        score_2++;
        sc2.setText(String.valueOf(score_2));
        status.setText("O Wins");
    }
}
