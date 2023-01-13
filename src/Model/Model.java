package Model;

import Other.GoL;
import View.*;

import java.util.ArrayList;

public class Model {
    private GoL test;
    private int w;
    private int h;

    public Model(int width, int height) {
        w = width;
        h = height;
        test = new GoL(width, height);         // idk
    }

    public void update() {
        // First checks how many alive neighbors each cell has and marks them
        /*
        for (int i = 0;;i++) {
            GoL.checkClose(i);          // problem in this syntax and in for-loop below, ?.something()
        }
        */

        // Then It flips all
        /*
        for (int o = 0;;o++) {
            GoL.flipAlive(o);
        }
        */


        //testing syntax
        for (int i = 0; i < w*h; i++) {
            test.checkClose(i);
        }
        //into
        for (int o = 0; o < w*h; o++) {
            test.flipAlive(o);
        }
    }

    public Shape[] getShapes() {
        /*
        Point[] point = {new Point(15,15)};       //test point, idk how to get my data in
        return (Shape[]) point;
         */

        ArrayList<Point> points = new ArrayList<Point>();
        points.add(new Point(7,8));
        points.add(new Point(8,9));
        points.add(new Point(9,7));
        points.add(new Point(9,8));
        points.add(new Point(9,9));

        Point[] pixelsToDisplay = new Point[points.size()];
        points.toArray(pixelsToDisplay);

        return (Shape[]) pixelsToDisplay;

        //return (Shape[]) test.getPoints();
    }

}
