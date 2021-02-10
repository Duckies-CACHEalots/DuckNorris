
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
    private final int CROCODILESNUMBER = 7;
    private Crocodile[] crocodiles;

    public Game(){

        duckNorris = new Duck("Duck Norris");

        // implement keyboard handler
        duckKeyboardHandler = new DuckKeyboardHandler(duckNorris);
        // instantiate keyboard
        keyboard = new Keyboard(duckKeyboardHandler);

        grid = new Grid();

        colisionDetector = new ColisionDetector(grid);
        //----------------------------------------------------------------------
        crocodiles = new Crocodile[CROCODILESNUMBER];
       // crocodiles[0] = new Crocodile("Crocodile 1", 21, 10, CrocodileDirectionType.VERTICAL);


        crocodiles[0] = new Crocodile("Crocodile 1", 0, 15, CrocodileDirectionType.VERTICAL);
        crocodiles[1] = new Crocodile("Crocodile 2", 5, 9, CrocodileDirectionType.HORIZONTAL);
        crocodiles[2] = new Crocodile("Crocodile 3", 11, 13, CrocodileDirectionType.VERTICAL);
        crocodiles[3] = new Crocodile("Crocodile 4", 21, 17, CrocodileDirectionType.HORIZONTAL);
        crocodiles[4] = new Crocodile("Crocodile 5", 17, 6, CrocodileDirectionType.VERTICAL);
        crocodiles[5] = new Crocodile("Crocodile 6", 27, 0, CrocodileDirectionType.HORIZONTAL);
        crocodiles[6] = new Crocodile("Crocodile 7", 27, 10, CrocodileDirectionType.HORIZONTAL);
    }

    public void init(){

        keyboard.addEventListener(KeyboardEvent.KEY_UP, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_DOWN, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_LEFT, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_RIGHT, KeyboardEventType.KEY_PRESSED);

        duckKeyboardHandler.setColisionDetector(colisionDetector);

        grid.init();
        duckNorris.init();

        //---------------------------------------------

        for (Crocodile crocodile : crocodiles) {

            crocodile.init();
            crocodile.setColisionDetector(colisionDetector);
            crocodile.setGrid(grid);
        }
    }

    public void start(){

        while (true){
            for (Crocodile crocodile : crocodiles) {
                crocodile.move();
            }

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


        }


    }

}
