import Controller.Controller;
import Model.Model;
import View.View;

public class GameOfLife {
    public static void main(String[] args) {
        int width = 80; // It even works on different width, height values
        int height = 60;
        int scale = 10;
        Model m = new Model(width, height);
        View v = new View(width, height, scale);
        Controller c = new Controller(m,v);
        c.start();
    }
}
