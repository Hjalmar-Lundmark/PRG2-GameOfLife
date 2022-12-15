package Other;

public class Cell {
    private boolean alive;
    private int X;
    private int Y;

    public Cell(boolean alive, int x, int y) {
        this.alive = alive;
        X = x;
        Y = y;
    }

    public boolean isAlive() {
        return alive;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void changeState() {
        alive = !alive;
        //return alive
    }
}
