import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

// Handle game logic and canvasing here

public class PongGame extends JPanel implements KeyListener {

    static final int windowWidth = 1024, windowHeight = 768;
    private Ball ball;
    private Paddle userPaddle, computerPaddle;
    private Score score;
    private int numBounces;

    public PongGame() {
        ball = new Ball(512, 384, 4, 4, 9, 4, Color.WHITE);    /// 2 2 2
        userPaddle = new Paddle(20, 334, 6, Color.WHITE);
        computerPaddle = new Paddle(windowWidth - 35, 334, 6, Color.WHITE);
        score = new Score(windowWidth, windowHeight);

        addKeyListener(this);
        setFocusable(true);
    }

    public void paintComponent(Graphics g) {

        // draws background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, windowWidth, windowHeight);

        // draws ball
        ball.drawBall(g);

        // draws paddles
        userPaddle.drawPaddle(g);
        computerPaddle.drawPaddle(g);

        // draws score
        score.drawScore(g);

        if(score.userScore == 10 || score.computerScore == 10) {
            score.drawWinner(g);
        }

    }

    public void gameLogic() {
        ball.moveBall();
        ball.hitEdges(0, windowHeight);     // check if ball collides with top or bottom edge

        computerPaddle.moveTo(ball.getY());                        // computer follows balls Y axis
        computerPaddle.hitEdges(0, windowHeight);              // disallow paddles moving out of bounds
        userPaddle.hitEdges(0, windowHeight);

        if(checkCollision(userPaddle, ball) || checkCollision(computerPaddle, ball)) {
            ball.reverseX();
            numBounces++;
        }

        if(numBounces > 3) {
            numBounces = 0;             // speed up ball every 4 bounces
            ball.addSpeed();
        }

        if(ball.getX() < 0) {
            score.computerScore++;
            reset();
        }
        if(ball.getX() > windowWidth) {
            score.userScore++;
            reset();
        }
        if(score.userScore > 10 || score.computerScore > 10) {
            score.resetScore();
       }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_UP) {
            userPaddle.up();
        }
        if(code == KeyEvent.VK_DOWN) {
            userPaddle.down();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    public boolean checkCollision(Paddle p, Ball b) {

        if(b.getX() > p.getX() - b.getSize() && b.getX() < p.getX() + p.getPad_Width()){    // if ball enters paddles x coordinates
            if(b.getY() > p.getY() && b.getY() < p.getY() + p.getPad_Height()) {            // if ball is also enters paddles y coordinates
                return true;
            }
        }
        return false;
    }

    public void reset() {

        // get a random 0 or 1 for each axis
        // if 0, set the axis to negative value

        Random random = new Random();
        int xDirection = random.nextInt(2);
        if(xDirection == 0) xDirection = -1;

        int yDirection = random.nextInt(2);
        if(yDirection == 0) yDirection = -1;

        ball.setX(512);
        ball.setY(384);
        ball.setCx(4 * xDirection);
        ball.setCy(4 * yDirection);
        ball.setSpeed(4);
    }

}
