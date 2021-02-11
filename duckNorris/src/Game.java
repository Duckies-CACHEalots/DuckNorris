import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public class Game {

    private DuckKeyboardHandler duckKeyboardHandler;
    private Keyboard keyboard;
    private Duck duckNorris;
    private Grid grid;
    private ColisionDetector colisionDetector;
    private final int crocodilesNumber = 7;
    private Crocodile[] crocodiles;
    private boolean gameOver;

    public Game(){

        duckNorris = new Duck("Duck Norris");

        // implement keyboard handler
        duckKeyboardHandler = new DuckKeyboardHandler(duckNorris);
        // instantiate keyboard
        keyboard = new Keyboard(duckKeyboardHandler);

        grid = new Grid();

        colisionDetector = new ColisionDetector(grid);
        //----------------------------------------------------------------------
        crocodiles = new Crocodile[crocodilesNumber];
        crocodiles[0] = new Crocodile("Crocodile 1", 0, 15, CrocodileDirectionType.VERTICAL);
        crocodiles[1] = new Crocodile("Crocodile 2", 5, 9, CrocodileDirectionType.HORIZONTAL);
        crocodiles[2] = new Crocodile("Crocodile 3", 11, 13, CrocodileDirectionType.VERTICAL);
        crocodiles[3] = new Crocodile("Crocodile 4", 21, 17, CrocodileDirectionType.HORIZONTAL);
        crocodiles[4] = new Crocodile("Crocodile 5", 17, 6, CrocodileDirectionType.VERTICAL);
        crocodiles[5] = new Crocodile("Crocodile 6", 27, 0, CrocodileDirectionType.HORIZONTAL);
        crocodiles[6] = new Crocodile("Crocodile 7", 27, 10, CrocodileDirectionType.HORIZONTAL);
    }

    public void init(){

        gameOver = false;

        keyboard.addEventListener(KeyboardEvent.KEY_UP, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_DOWN, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_LEFT, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_RIGHT, KeyboardEventType.KEY_PRESSED);

        duckKeyboardHandler.setColisionDetector(colisionDetector);

        grid.init();
        duckNorris.init();

        for (Crocodile crocodile : crocodiles) {
            crocodile.init();
            crocodile.setColisionDetector(colisionDetector);
            crocodile.setGrid(grid);
        }
        //colisionDetector.setCrocodiles(crocodiles);
    }

    public void start(){

        while(!gameOver){

            for (Crocodile crocodile : crocodiles) {
                crocodile.move();

                if (colisionDetector.checkCollision(duckNorris.getPosition(), crocodile.getPositions())) {
                    duckNorris.decreaseLives();
                    System.out.println("crashou. Lives: " + duckNorris.getLives());
                    duckNorris.goToInitialPosition();

                    if(duckNorris.getLives() == 0){
                        System.out.println("Game Over");
                        gameOver = true;
                    }
                }
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }

        }

    }

}
