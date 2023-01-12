package Other;

import Other.Cell;
import View.Point;

import java.util.ArrayList;

public class GoL {          // The world/board
    private Cell[] cells;
    private int width;
    private int height;

    public GoL(int Width, int Height) {
        this.width = Width;
        this.height = Height;
        boolean test = false;

        cells = new Cell[width*height];
        for (int i = 0; i < width; i++) {
            for (int o = 0; o < height; o++) {      //think this correct?
                test = !test;                       // every other one is alive shenanigans
                cells[i] = new Cell(test, i, o);
            }
        }

        //maybe set alives here, to make a pattern
        cells[5+(width*2)].setAlive(true);
        cells[6+(width*2)].setAlive(true);
        cells[7+(width*2)].setAlive(true);
    }

    public void checkClose(int i /* OR cell maybe? */) {
        int neighbors = 0;
        if (this.cells[i+1].isAlive()) {
            neighbors++;
        }
        if (this.cells[i-1].isAlive()) {              //edge case(s), dont know what to do
            neighbors++;
        }
        if (this.cells[i-1-width].isAlive()) {        // row above?
            neighbors++;
        }
        if (this.cells[i-width].isAlive()) {
            neighbors++;
        }
        if (this.cells[i+1-width].isAlive()) {
            neighbors++;
        }
        if (this.cells[i-1+width].isAlive()) {      // next row
            neighbors++;
        }
        if (this.cells[i+width].isAlive()) {
            neighbors++;
        }
        if (this.cells[i+1+width].isAlive()) {
            neighbors++;
        }

        //save neighbor in the cell, as int or bool
        this.cells[i].setNr(neighbors);

    }

    public void flipAlive(int i) {
        // wack
        if ((this.cells[i].getNr() < 2 || this.cells[i].getNr() > 3) && this.cells[i].isAlive()) {
            //om levande, döda dem
            this.cells[i].changeState();
        } else if (!this.cells[i].isAlive() && this.cells[i].getNr() == 3) {
            this.cells[i].changeState();
        }


    }

    public Point[] getPoints() {
        ArrayList<Point> points = new ArrayList<Point>();
        for (Cell c : cells) {      // idk
            if (c.isAlive()) {
                points.add(new Point(c.getX(), c.getY()));
            }
        }
        Point[] pointDisplay = new Point[points.size()];
        points.toArray(pointDisplay);
        return pointDisplay;
    }

}
