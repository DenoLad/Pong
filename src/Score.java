import java.awt.*;

public class Score {

    public int userScore, computerScore;
    static int windowWidth, windowHeight;

    Score(int windowWidth, int windowHeight) {
        Score.windowWidth = windowWidth;
        Score.windowHeight = windowHeight;
    }

    public void drawScore(Graphics g) {
        g.setColor(Color.WHITE);
        Font font = new Font("Consolas", Font.BOLD, 50);
        g.setFont(font);
        g.drawString(String.valueOf(userScore), windowWidth / 2 - 50, 50);
        g.drawString(String.valueOf(computerScore), windowWidth / 2 + 50, 50);
    }

    public void drawWinner(Graphics g) {
        g.setColor(Color.WHITE);
        Font font = new Font("Consolas", Font.BOLD, 50);
        g.setFont(font);

        if(userScore == 10) {
            g.drawString("Congratulations, you win!", (windowWidth/ 2) / 2, 400);
        }
        if(computerScore == 10) {
            g.drawString("Sorry, computer wins!", (windowWidth / 2) / 2, 400);
        }
    }

    public void resetScore() {
        userScore = 0;
        computerScore = 0;
    }

}
