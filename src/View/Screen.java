package View;

/**
 * This is a class
 * Created 2021-10-18
 *
 * @author Magnus Silverdal
 */
public class Screen {
    private int[] pixels;
    private int width;
    private int height;

    public Screen(int[] pixels, int width, int height) {
        this.width = width;
        this.height = height;
        this.pixels = pixels;
    }

    public void draw(int x, int y , int color) {
        pixels[y*width+x] = color;
    }

    public void draw(Point p, int color) {
        draw(p.getX(), p.getY(), color);
    }

    public void draw(Sprite s) {
        for (int ys = 0 ; ys < s.getHeight() ; ys++) {
            for (int xs = 0 ; xs < s.getWidth() ; xs++) {
                pixels[s.getX()+xs+width*(s.getY()+ys)] = s.getPixels()[xs + ys*s.getWidth()];
            }
        }
    }

    public void clear() {
        for (int i = 0 ; i < pixels.length; i++) {
            pixels[i] = 0x0;
        }
    }
}

