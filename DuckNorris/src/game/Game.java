package game;

import characters.Duck;
import characters.DuckKeyboardHandler;
import coreInfo.CollisionDetector;
import layers.FogLayer;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import layers.Grid;
import layers.FieldOfVision;
import characters.*;

import javax.swing.*;

public class Game {


    private DuckKeyboardHandler duckKeyboardHandler;
    private Keyboard keyboard;
    private Duck duckNorris;
    private Grid grid;
    private CollisionDetector collisionDetector;
    private FieldOfVision fieldOfVision;
    private FogLayer fog;
    public Picture startpic;
    private final int crocodilesNumber = 7;
    private Crocodile[] crocodiles;
    private boolean gameOver;

    public Game(){

        duckNorris = new Duck("Duck Norris");

        startpic = new Picture (10, 10, "resources/startpic1.jpeg");

        // implement keyboard handler
        duckKeyboardHandler = new DuckKeyboardHandler(duckNorris, startpic);
        // instantiate keyboard
        keyboard = new Keyboard(duckKeyboardHandler);

        grid = new Grid();

        collisionDetector = new CollisionDetector(grid);

        this.fog = new FogLayer();
        this.fieldOfVision = new FieldOfVision(fog, duckNorris.getPosition());

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
        keyboard.addEventListener(KeyboardEvent.KEY_S, KeyboardEventType.KEY_PRESSED);

        duckKeyboardHandler.setObstacleDetector(collisionDetector);

        grid.init();

        Picture background = new Picture(10,10, "resources/bg.jpeg");
        background.draw();
        duckNorris.init();

        for (Crocodile crocodile : crocodiles) {
            crocodile.init();
            crocodile.setCollisionDetector(collisionDetector);
            crocodile.setGrid(grid);
        }

        fog.init();
        fieldOfVision.init();
        duckKeyboardHandler.setFieldOfVision(fieldOfVision);

        startpic.draw();

        //colisionDetector.setCrocodiles(crocodiles);
    }

    public void start(){

        while(!gameOver){

            for (Crocodile crocodile : crocodiles) {
                crocodile.move();

                if (collisionDetector.checkCollision(duckNorris.getPosition(), crocodile.getPositions())) {
                    duckNorris.goToInitialPosition();
                    duckNorris.decreaseLives();

                    fieldOfVision.restartBorders();
                    fieldOfVision.init();

                    //JOptionPane.showMessageDialog(null, "Try again... " + duckNorris.getLives() + " lives left");
                    System.out.println("crashou. Lives: " + duckNorris.getLives());

                    if(duckNorris.getLives() == 0){
                        System.out.println("Game Over");
                        gameOver = true;
                        JOptionPane.showMessageDialog(null, "Game over. You killed Duck Norris...");
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
