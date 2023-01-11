import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {

    static JFrame frame = new JFrame("Pong by Dennis Dervisevic");  //JFrame allows hide or close window with setDefaultCloseOperation() compared to Frame


    public static void main(String[] args) {

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1039, 783);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);     // set frame to center of screen
        PongGame game = new PongGame();
        frame.add(game);
        frame.setVisible(true);


        //Using swing Timer. Delay is in ms.
        Timer timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.gameLogic();
                game.repaint();
            }
        });

        timer.start();

    }
}
