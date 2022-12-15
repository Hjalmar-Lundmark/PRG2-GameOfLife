package Other;

import Other.Cell;

public class GoL {
    Cell[] c;

    public GoL(Cell[] c) {
        this.c = c;
    }

    public void checkClose() {
        int neighbors = 0;

        //tbh idk
        for (int i = 0;;i++) {
            neighbors = 0;
            if (c[i].isAlive()) {   //should be neighbor 1 but is c right now
                neighbors++;
            }
            if () {

            }
        }
    }


}
