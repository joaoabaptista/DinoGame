import com.codeforall.online.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Cato implements Move{

    private String imagePath;
    private int x;
    private int y;
    private Dino dino;
    //private Picture picture;
    private Canvas canvas;
    private CopyOnWriteArrayList<Picture> catos;

    public Cato(Dino dino, Canvas canvas) {
        this.imagePath = "images/catos.png";
        this.x = 300;
        this.y = canvas.getCanvasHeight();
        this.dino = dino;
        this.canvas = canvas;
        this.catos = new CopyOnWriteArrayList<>();
    }

    int catoHeight = 70;
    int catoWidth = 56;

    public void show(){
        new Thread(() -> {
            while(true){
                Picture newCato = new Picture(
                        canvas.getCanvasWidth() + catoWidth,
                        canvas.getGroundY() - catoHeight,
                        imagePath);
                newCato.draw();
                catos.add(newCato);
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
            }
        }).start();

    }

    @Override
    public void move() {
        new Thread(() -> {
            while(true) {
                for(Picture cato : catos){
                    cato.translate(-1,0);
                    if(cato.getX() + catoWidth < 0){
                        cato.delete();
                    }
                }
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    public int getX(){
        return x;
    }
}
