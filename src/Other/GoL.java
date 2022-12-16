package Other;

import Other.Cell;
import View.Point;

import java.util.ArrayList;

public class GoL {
    private Cell[] cells;
    private int width;
    private int height;

    public GoL(int Width, int Height) {
        this.width = Width;
        this.height = Height;
        boolean test = false;

        cells = new Cell[width*height];
        for (int i = 0; i < cells.length; i++) {
            for (int o = 0; o < cells.length; o++) {
                test = !test;
                cells[i] = new Cell(test, i, o);         //idk
            }
        }


    }

    public void checkClose() {
        int neighbors = 0;

        //for-loop through all points/cells

        for (int i = 0;;i++) {
            neighbors = 0;
            if (c[i].isAlive()) {   //should be neighbor 1 but is c right now
                neighbors++;
            }
            if (c[i+1].isAlive()) {     //should be n2, but c-coords +1 not c[i]+1
                neighbors++;
            }
            if (c[i+2].isAlive()) {
                neighbors++;
            }
            if (c[i+3].isAlive()) {
                neighbors++;
            }
            if (c[i+4].isAlive()) {
                neighbors++;
            }
            if (c[i+5].isAlive()) {
                neighbors++;
            }
            if (c[i+6].isAlive()) {
                neighbors++;
            }
            if (c[i+7].isAlive()) {
                neighbors++;
            }


            if ((neighbors < 2 || neighbors > 3) && c[i].isAlive()) {
                //om levande, döda dem
                //men hur ändrar jag den exakta cellen?
                c[i].changeState();
            } else if (!c[i].isAlive() && neighbors == 3) {
                c[i].changeState();
            }
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
