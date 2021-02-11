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
        
        //instantiate grid && obstacles
        grid = new Grid();
        obstacleDetector = new ObstacleDetector(grid);
        
        // instantiates fog layer on top of the game board and creates the field of vision in which the ducks has visibility
        this.fog = new FogLayer();
        this.fieldOfVision = new FieldOfVision(fog, duckNorris.getPosition());


    }

    public void init(){

        keyboard.addEventListener(KeyboardEvent.KEY_UP, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_DOWN, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_LEFT, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_RIGHT, KeyboardEventType.KEY_PRESSED);

        duckKeyboardHandler.setColisionDetector(colisionDetector);


        grid.init();
        duckNorris.init();
        fog.init();
        fieldOfVision.init();
        duckKeyboardHandler.setFieldOfVision(fieldOfVision);

    }

    public void start(){


    }

}
