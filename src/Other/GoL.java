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
        int arrayVal = 0;
        for (int i = 0; i < width; i++) {
            test = !test;
            for (int o = 0; o < height; o++) {      //think this correct?
                test = !test;                       // every other one is alive shenanigans
                cells[arrayVal] = new Cell(test, i, o);
                arrayVal++;
            }
        }

        //maybe set alives here, to make a pattern
        /*
        cells[15+(width*12)].setAlive(true);
        cells[16+(width*12)].setAlive(true);
        cells[17+(width*12)].setAlive(true);


        cells[103].setAlive(true);
        cells[153].setAlive(true);
        cells[203].setAlive(true);

        cells[104].setAlive(true);
        cells[154].setAlive(true);
        cells[204].setAlive(true);

        cells[105].setAlive(true);
        cells[155].setAlive(true);
        cells[205].setAlive(true);
        */

    }

    public void checkClose(int i) {     //coordinates for the NBs are wrong
        int neighbors = 0;

        if (i+1 < width*height) {   //first 2 ifs in each are for checking edge cases, lets hope this works
            if (this.cells[i].getX() == this.cells[i+1].getX()) {
                if (this.cells[i + 1].isAlive()) {
                    neighbors++;
                }
            }
        }
        if (i-1 >= 0) {//
            if (this.cells[i].getX() == this.cells[i-1].getX()) {
                if (this.cells[i - 1].isAlive()) {              //edge case(s)
                    neighbors++;
                }
            }
        }
        if (i-1-width >= 0) {//
            if (this.cells[i].getX() == (this.cells[i-1-width].getX()+1)) {
                if (this.cells[i - 1 - width].isAlive()) {        // row above
                    neighbors++;
                }
            }
        }
        if (i-width >= 0) {//
            if (this.cells[i].getX() == (this.cells[i-width].getX()+1)) {
                if (this.cells[i - width].isAlive()) {
                    neighbors++;
                }
            }
        }
        if (i+1-width >= 0) {//
            if (this.cells[i].getX() == (this.cells[i+1-width].getX()+1)) {
                if (this.cells[i + 1 - width].isAlive()) {
                    neighbors++;
                }
            }
        }
        if (i-1+width < width*height) {//
            if (this.cells[i].getX() == (this.cells[i-1+width].getX()-1)) {
                if (this.cells[i - 1 + width].isAlive()) {      // next row
                    neighbors++;
                }
            }
        }
        if (i+width < width*height) {      //something wrong here?
            if (this.cells[i].getX() == (this.cells[i+width].getX()-1)) {
                if (this.cells[i + width].isAlive()) {
                    neighbors++;
                }
            }
        }
        if (i+1+width < width*height) {
            if (this.cells[i].getX() == (this.cells[i+1+width].getX()-1)) {
                if (this.cells[i + 1 + width].isAlive()) {
                    neighbors++;
                }
            }
        }

        //save neighbor in the cell, as int or bool
        this.cells[i].setNr(neighbors);

    }

    public void flipAlive(int i) {
        if (this.cells[i].isAlive()) {
            //om levande, döda dem
            if (this.cells[i].getNr() < 2 || this.cells[i].getNr() > 3) {
                this.cells[i].setAlive(false);
                System.out.println(" something ded!💀");
            }
        } else if (!this.cells[i].isAlive()) {
            if (this.cells[i].getNr() == 3) {
                this.cells[i].setAlive(true);
                System.out.println(" something alive!");
            }
        }
    }

    public Point[] getPoints() {        //I dont remember what this does
        ArrayList<Point> points = new ArrayList<Point>();
        for (/*Cell c : cells*/ int p = 0; p < width*height; p++) {      // idk
            if (this.cells[p].isAlive()) {
                points.add(new Point(this.cells[p].getX(), this.cells[p].getY()));
            }
        }
        Point[] pointDisplay = new Point[points.size()];
        points.toArray(pointDisplay);
        return pointDisplay;
    }

}
