import com.codeforall.online.simplegraphics.graphics.Color;
import com.codeforall.online.simplegraphics.graphics.Rectangle;

import java.awt.*;

public class Canvas {

    private int canvasWidth;
    private int canvasHeight;
    private int padding;

    public Canvas(int canvasWidth, int canvasHeight) {
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        this.padding = 10;
    }

    public int getCanvasWidth() {
        return canvasWidth;
    }
    public int getCanvasHeight() {
        return canvasHeight;
    }

    public void init(){
        Rectangle field = new Rectangle(padding, padding, canvasWidth, canvasHeight);
        field.draw();
        ground();
    }
    public void ground(){
        Rectangle ground = new Rectangle (padding, getCanvasHeight() - padding, getCanvasWidth(), 5);
        ground.setColor(Color.DARK_GRAY);
        ground.fill();
    }

    public int getGroundY(){
        return getCanvasHeight() - padding;

    }
}
