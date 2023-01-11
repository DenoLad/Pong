import java.awt.*;

public class Paddle {
    private int x, y, speed;
    private Color color;
    static final int pad_Width = 15, pad_Height = 125;

    public Paddle(int x, int y, int speed, Color color) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.color = color;
    }

    public void drawPaddle(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawRect(x, y, pad_Width, pad_Height);
    }

    public void up(){
        y += -speed;
    }

    public void down() {
        y += speed;
    }

    public void moveTo(int targetY) {
        int centerY = y + pad_Height / 2;

        // x = 0, y = 0 is upper left corner
        // if distance to targetY is less than speed no need to move paddle
        if(Math.abs(centerY - targetY) > speed) {
            if (centerY < targetY) y += speed;
            if (centerY > targetY) y -= speed;
        }
    }

    public void hitEdges(int top, int bottom) {
        if(y < 0) y = 0;
        if(y > PongGame.windowHeight - pad_Height - 25) y = PongGame.windowHeight - pad_Height - 25;
    }

    public int getY() {
        return y;
    }

    public int getX() { return x; }

    public void setY(int y) {
        this.y = y;
    }

    public int getPad_Height() {
        return pad_Height;
    }

    public int getPad_Width() { return pad_Width; }


}
