package Model;

import Other.GoL;
import View.*;

public class Model {
    private GoL test;

    public Model(int width, int height) {
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
        for (int i = 0;    ;i++) {
            test.checkClose(i);
        }
        //into
        for (int o = 0;    ;o++) {
            test.flipAlive(o);
        }
    }

    public Shape[] getShapes() {
        Point[] point = {new Point(15,15)};       //test point, idk how to get my data in


        return (Shape[]) point;
    }

}
