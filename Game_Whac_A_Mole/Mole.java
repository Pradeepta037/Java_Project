public class Mole {
    private int x;
    private int y;
    private boolean isActive;

    public Mole() {
        this.x = -1;
        this.y = -1;
        this.isActive = false;
    }

    public void appear(int x, int y) {
        this.x = x;
        this.y = y;
        this.isActive = true;
    }

    public void disappear() {
        this.isActive = false;
    }

    public boolean isActive() {
        return isActive;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
