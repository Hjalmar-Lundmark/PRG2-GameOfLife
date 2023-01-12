package Other;

public class Cell {
    private boolean alive;
    private int X;
    private int Y;
    //need int or another bool to know if flip so that I can flip all at once
    private int nr;         // for neighbors

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

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public void changeState() {             // change to opposit
        alive = !alive;
        //return alive
    }

    public void setAlive(boolean in) {      // change to in-value
        alive = in;
    }
}
