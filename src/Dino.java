import com.codeforall.online.simplegraphics.pictures.Picture;

public class Dino {
    private int x;
    private int y;
    private Picture picture;
    private String picturePath;
    private Canvas canvas;

    public Dino(Canvas canvas) {
        this.x = 400;
        this.picturePath = "images/dinos.png" ;
        this.canvas = canvas;

        this.picture = new Picture(0,0, this.picturePath); //inicializo a imagem na posiçao temporaria para poder usar o metodo getimageHeigth
        this.y = canvas.getCanvasHeight()-picture.getHeight()-5;

    }

    public int getImageHeight() {
        return picture.getHeight();
    }

    public void show() {
        picture.translate(this.x, this.y);
        picture.draw();
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
        picture.translate(0, y - picture.getY());
    }
}
