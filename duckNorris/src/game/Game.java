package game;

import characters.Duck;
import characters.DuckKeyboardHandler;
import coreInfo.ObstacleDetector;
import layers.FieldOfVision;
import layers.FogLayer;
import layers.Grid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {


    private DuckKeyboardHandler duckKeyboardHandler;
    private Keyboard keyboard;
    private Duck duckNorris;
    private Grid grid;
    private ObstacleDetector colisionDetector;
    private FieldOfVision fieldOfVision;
    private FogLayer fog;

    public Game(){

        duckNorris = new Duck("Duck Norris");


        // implement keyboard handler
        duckKeyboardHandler = new DuckKeyboardHandler(duckNorris);
        // instantiate keyboard
        keyboard = new Keyboard(duckKeyboardHandler);

        grid = new Grid();

        colisionDetector = new ObstacleDetector(grid);

        this.fog = new FogLayer(grid);
        this.fieldOfVision = new FieldOfVision(fog, duckNorris.getPosition());


    }

    public void init(){

        keyboard.addEventListener(KeyboardEvent.KEY_UP, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_DOWN, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_LEFT, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_RIGHT, KeyboardEventType.KEY_PRESSED);

        duckKeyboardHandler.setColisionDetector(colisionDetector);


        grid.init();

        Picture background = new Picture(10,10, "resources/bgcolor.jpg");
        background.draw();

        duckNorris.init();
        //fog.init();
        fieldOfVision.init();
        fieldOfVision.setCenterPos(duckNorris.getPosition());
        duckKeyboardHandler.setFieldOfVision(fieldOfVision);

    }

    public void start(){


    }

}
