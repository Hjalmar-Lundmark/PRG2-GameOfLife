package Model;

import View.*;

public class Model {
    private int width;
    private int height;

    public Model(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void update() {
        //do stuff
        //idk, checkNeighbor
        //GoL.checkClose();

    }

    public Shape[] getShapes() {
        Point[] point = {new Point(15,15)};       //test point???
        return (Shape[]) point;
    }

}
