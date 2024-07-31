public class Pipe {
    private int x, y;
    private final int width = 50;
    private final int gap = 100;

    public Pipe(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    public void move() {
        this.x -= 5;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getGap() {
        return gap;
    }

    public boolean collidesWith(Bird bird) {
        return bird.getX() + 10 > x && bird.getX() < x + width &&
               (bird.getY() < y || bird.getY() + 10 > y + gap);
    }
}
