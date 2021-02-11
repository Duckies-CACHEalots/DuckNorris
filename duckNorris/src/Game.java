
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {


    private DuckKeyboardHandler duckKeyboardHandler;
    private Keyboard keyboard;
    private Duck duckNorris;
    private Grid grid;
    private ColisionDetector colisionDetector;


    public Game(){

        duckNorris = new Duck("Duck Norris");

        // implement keyboard handler
        duckKeyboardHandler = new DuckKeyboardHandler(duckNorris);
        // instantiate keyboard
        keyboard = new Keyboard(duckKeyboardHandler);

        grid = new Grid();

        colisionDetector = new ColisionDetector(grid);
    }

    public void init(){

        keyboard.addEventListener(KeyboardEvent.KEY_UP, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_DOWN, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_LEFT, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_RIGHT, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_S, KeyboardEventType.KEY_PRESSED);

        duckKeyboardHandler.setColisionDetector(colisionDetector);

        grid.init();
        duckNorris.init();

    }

    public void start(){


    }

}
