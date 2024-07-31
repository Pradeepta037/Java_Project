public class Bird {
    private int x, y;
    private int velocity;
    private final int gravity = 1;
    private final int jumpStrength = -10;

    public Bird(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.velocity = 0;
    }

    public void flap() {
        this.velocity = jumpStrength;
    }

    public void update() {
        this.velocity += gravity;
        this.y += velocity;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
