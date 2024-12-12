import com.codeforall.online.simplegraphics.keyboard.Keyboard;
import com.codeforall.online.simplegraphics.keyboard.KeyboardEvent;
import com.codeforall.online.simplegraphics.keyboard.KeyboardEventType;
import com.codeforall.online.simplegraphics.keyboard.KeyboardHandler;

public class SpaceKey implements KeyboardHandler {
    private Keyboard keyboard;
    private Jump jump; // Referência ao salto do Dino

    public SpaceKey(Jump jump) {
        this.jump = jump; // Conecta o SpaceKey ao comportamento de salto

        // Inicializa o teclado
        keyboard = new Keyboard(this);

        // Configura o evento de tecla pressionada (barra de espaço)
        KeyboardEvent spaceKey = new KeyboardEvent();
        spaceKey.setKey(KeyboardEvent.KEY_SPACE);
        spaceKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(spaceKey);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            //System.out.println("SpaceKey pressed");

            // Faz o Dino pular
            jump.startJump();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        // Não faz nada ao liberar a tecla
    }
}

