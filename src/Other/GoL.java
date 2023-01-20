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
        int rand;
        for (int i = 0; i < width; i++) {
            //test = !test;
            for (int o = 0; o < height; o++) {      //think this correct?
                //test = !test;                       // every other one is alive shenanigans

                /* //Every tile has 50/50 chance of living at the start
                rand = (int) (Math.random()*2);
                if (rand == 1) {
                    test = !test;
                }*/
                cells[arrayVal] = new Cell(test, i, o);
                arrayVal++;
            }
        }

        //setAlive here, to make a pattern

        //3x1 line
        /*
        cells[15+(height*12)].setAlive(true);
        cells[16+(height*12)].setAlive(true);
        cells[17+(height*12)].setAlive(true);
        */

        //3x3 square
        /* //TODO: change these to x+y*height
        cells[503].setAlive(true);
        cells[553].setAlive(true);
        cells[603].setAlive(true);

        cells[504].setAlive(true);
        cells[554].setAlive(true);
        cells[604].setAlive(true);

        cells[505].setAlive(true);
        cells[555].setAlive(true);
        cells[605].setAlive(true);
        */

        //Flyer
        /*
        cells[255].setAlive(true);
        cells[306].setAlive(true);
        cells[207].setAlive(true);
        cells[257].setAlive(true);
        cells[307].setAlive(true);
        */

        //Gosper Glider Gun

        cells[8+4*height].setAlive(true);
        cells[8+5*height].setAlive(true);
        cells[9+4*height].setAlive(true);
        cells[9+5*height].setAlive(true);

        cells[6+38*height].setAlive(true);
        cells[6+39*height].setAlive(true);
        cells[7+38*height].setAlive(true);
        cells[7+39*height].setAlive(true);

        cells[8+14*height].setAlive(true);
        cells[9+14*height].setAlive(true);
        cells[10+14*height].setAlive(true);
        cells[7+15*height].setAlive(true);
        cells[11+15*height].setAlive(true);
        cells[6+16*height].setAlive(true);
        cells[6+17*height].setAlive(true);
        cells[12+16*height].setAlive(true);
        cells[12+17*height].setAlive(true);
        cells[9+18*height].setAlive(true);
        cells[7+19*height].setAlive(true);
        cells[11+19*height].setAlive(true);
        cells[8+20*height].setAlive(true);
        cells[9+20*height].setAlive(true);
        cells[10+20*height].setAlive(true);
        cells[9+21*height].setAlive(true);

        cells[6+24*height].setAlive(true);
        cells[6+25*height].setAlive(true);
        cells[7+24*height].setAlive(true);
        cells[7+25*height].setAlive(true);
        cells[8+24*height].setAlive(true);
        cells[8+25*height].setAlive(true);
        cells[5+26*height].setAlive(true);
        cells[9+26*height].setAlive(true);
        cells[5+28*height].setAlive(true);
        cells[4+28*height].setAlive(true);
        cells[9+28*height].setAlive(true);
        cells[10+28*height].setAlive(true);


    }

    public void checkClose(int i) {
        int neighbors = 0;

        if (i+1 < width*height) {   //first 2 ifs in each are for checking edge cases, lets hope this works
            if (this.cells[i].getX() == this.cells[i+1].getX()) {
                if (this.cells[i + 1].isAlive()) {
                    neighbors++;
                }
            }
        }
        if (i-1 >= 0) {
            if (this.cells[i].getX() == this.cells[i-1].getX()) {
                if (this.cells[i - 1].isAlive()) {              //edge case(s)
                    neighbors++;
                }
            }
        }
        if (i-1-height >= 0) {
            if (this.cells[i].getX() == (this.cells[i-1-height].getX()+1)) {
                if (this.cells[i - 1 - height].isAlive()) {        // row above
                    neighbors++;
                }
            }
        }
        if (i-height >= 0) {
            if (this.cells[i].getX() == (this.cells[i-height].getX()+1)) {
                if (this.cells[i - height].isAlive()) {
                    neighbors++;
                }
            }
        }
        if (i+1-height >= 0) {
            if (this.cells[i].getX() == (this.cells[i+1-height].getX()+1)) {
                if (this.cells[i + 1 - height].isAlive()) {
                    neighbors++;
                }
            }
        }
        if (i-1+height < width*height) {
            if (this.cells[i].getX() == (this.cells[i-1+height].getX()-1)) {
                if (this.cells[i - 1 + height].isAlive()) {      // next row
                    neighbors++;
                }
            }
        }
        if (i+height < width*height) {
            if (this.cells[i].getX() == (this.cells[i+height].getX()-1)) {
                if (this.cells[i + height].isAlive()) {
                    neighbors++;
                }
            }
        }
        if (i+1+height < width*height) {
            if (this.cells[i].getX() == (this.cells[i+1+height].getX()-1)) {
                if (this.cells[i + 1 + height].isAlive()) {
                    neighbors++;
                }
            }
        }

        //save neighbor in the cell, as int or bool
        this.cells[i].setNr(neighbors);

    }

    public void flipAlive(int i) {
        if (this.cells[i].isAlive()) {
            //if alive, kill it
            if (this.cells[i].getNr() < 2 || this.cells[i].getNr() > 3) {
                this.cells[i].setAlive(false);
                //System.out.println("something died!💀");
            }
        } else if (!this.cells[i].isAlive()) {
            if (this.cells[i].getNr() == 3) {
                this.cells[i].setAlive(true);
                //System.out.println("something alive!😀");
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
