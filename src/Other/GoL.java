package Other;

import Other.Cell;

public class GoL {
    Cell[] c;

    public GoL(Cell[] c) {
        this.c = c;
    }

    public void checkClose() {
        int neighbors = 0;

        //for loop through all points
        /*
        for (int i = 0;;i++) {
            neighbors = 0;
            if (c[i].isAlive()) {   //should be neighbor 1 but is c right now
                neighbors++;
            }
            if (c[i+1].isAlive()) {     //should be n2, but c-coords +1 not c[i]+1
                neighbors++;
            }
            if () {

            }


            if ((neighbors < 2 || neighbors > 3) && c.isAlive) {
                //om levande, döda
                //men hur ändrar jag den exakta
                c.changeState();
            }
        }

         */

    }


}
