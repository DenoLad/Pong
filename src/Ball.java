import java.awt.*;

public class Ball {
    private int x;
    private int y;
    private int cx;
    private int cy;
    private int size;
    private int speed;
    private Color color;
    static final int MAX_SPEED = 9;

    public Ball(int x, int y, int cx, int cy, int size, int speed, Color color) {
        this.x = x;
        this.y = y;
        this.cx = cx;
        this.cy = cy;
        this.size = size;
        this.speed = speed;
        this.color = color;
    }

    public void drawBall(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }

    public void moveBall(){
        x += cx;
        y += cy;
    }

    public void hitEdges(int top, int bottom) {
        // check if ball "hits" top or bottom edge and keep it in bounds

        if(y < top) reverseY();
        else if (y > bottom - 25 - size) reverseY();
    }

    public void addSpeed() {
        if(speed < MAX_SPEED) {
            speed++;

            if (cx > 0) {
                cx = speed;
            } else if (cx < 0) {
                cx = -1 * speed;
            }

            if (cy > 0) {
                cy = speed;
            } else if (cy < 0) {
                cy = -1 * speed;
            }
        }
    }

    public void reverseX() {
        cx *= -1;
    }

    public void reverseY() {
        cy *= -1;
    }

    public int getY(){
        return y;
    }

    public int getX() {return x; }

    public void setY(int y) { this.y = y; }

    public void setX(int x) { this.x = x; }

    public void setCx(int cx) { this.cx = cx; }

    public void setCy(int cy) { this.cy = cy; }

    public void setSpeed(int speed) { this.speed = speed; }

    public int getSize() { return size; }

}
