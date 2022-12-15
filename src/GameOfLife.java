import Controller.Controller;
import Model.Model;
import View.View;

public class GameOfLife {
    public static void main(String[] args) {
        int width = 50;
        int height = 50;
        int scale = 10;
        Model m = new Model(width, height);
        View v = new View(width, height, scale);
        Controller c = new Controller(m,v);
        c.start();
    }
}
