package View;

import javax.swing.*;
import java.awt.*;

public class View {
    public static String title = "GameOfLife";
    private JFrame frame;
    private ScreenRenderer renderer;

    public View(int width, int height, int scale) {
        frame = new JFrame();
        renderer = new ScreenRenderer(width, height,scale);
        frame.add(renderer);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(width*scale,height*scale));
    }

    public void draw(Shape[] shapesToDraw) {
        renderer.draw(shapesToDraw);
        renderer.render();
    }

    public void setVisible() {
        frame.setVisible(true);
    }
}
