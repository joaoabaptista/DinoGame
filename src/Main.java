import com.codeforall.online.simplegraphics.graphics.Rectangle;
import com.codeforall.online.simplegraphics.pictures.Picture;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Canvas canvas = new Canvas(1700, 400);
        canvas.init();
        // SpaceKey key = new SpaceKey();


        Dino dino = new Dino(canvas);
        dino.show();

        Cato cato = new Cato(dino, canvas);
        cato.show();
        cato.move();

        Jump jump = new Jump(dino); // Configura altura máxima do salto

        // Configura o teclado para detectar a barra de espaço
        SpaceKey spaceKey = new SpaceKey(jump);

    }}