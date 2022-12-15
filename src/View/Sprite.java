package View;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * This is a class
 * Created 2021-10-25
 *
 * @author Magnus Silverdal
 */
public class Sprite extends Shape{
    private int x;
    private int y;
    private int width;
    private int height;
    private int[] pixels;

    public Sprite(int x, int y, BufferedImage image) {
        this.x  = x;
        this.y = y;
        this.width = image.getWidth();
        this.height = image.getHeight();
        BufferedImage imageARGB = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_ARGB);
        imageARGB.getGraphics().drawImage(image  ,0,0,null);
        pixels = ((DataBufferInt) imageARGB.getRaster().getDataBuffer()).getData();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[] getPixels() {
        return pixels;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}
