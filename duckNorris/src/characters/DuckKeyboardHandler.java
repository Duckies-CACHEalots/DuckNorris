package characters;

import coreInfo.ObstacleDetector;
import game.Game;
import layers.FieldOfVision;
import layers.Grid;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class DuckKeyboardHandler implements KeyboardHandler {

    private final int moveUP = Grid.CELLSIZE;
    private final int moveDown = Grid.CELLSIZE;
    private final int moveLeft = Grid.CELLSIZE;
    private final int moveRight = Grid.CELLSIZE;

    private Duck duck;
    private Picture pic;
    private ObstacleDetector colisionDetector;
    private FieldOfVision fieldOfVision;
    private Picture startpic;


    public DuckKeyboardHandler(Duck duck, Picture startpic){
        this.duck = duck;
        pic = duck.getPic();
        this.startpic = startpic;
        //duck.setPic("resources/duckLeft.png");
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()){

            case KeyboardEvent.KEY_S:
                startpic.delete();

            case KeyboardEvent.KEY_UP:

            pic.load("resources/duckUp.png");

               if (!colisionDetector.isCellAvailable(duck.getPosition(), DirectionType.UP)){
                    return;
               }

                //duck.setPic("resources/duckUp.png");

                pic.translate(0, -moveUP);
                duck.getPosition().setRow(duck.getPosition().getRow() - 1);

                //pic.delete();
                //duck.setPic("resources/duckUp.png");
               // pic = duck.getPicUp();

               // if ()//need to check if next cells are visible, if they are there's no need to call defog.

                fieldOfVision.defog(DirectionType.UP);

                break;

            case KeyboardEvent.KEY_DOWN:

                pic.load("resources/duckDown.png");

               if (!colisionDetector.isCellAvailable(duck.getPosition(), DirectionType.DOWN)){
                    return;
                }

              //  duck.setPic("resources/duckDown.png");

                pic.translate(0, moveDown);
                duck.getPosition().setRow(duck.getPosition().getRow() + 1);

               // pic.delete();
                //duck.setPic("resources/duckDown.png");
                //pic = duck.getPicDown();

                fieldOfVision.defog(DirectionType.DOWN);

                break;

            case KeyboardEvent.KEY_LEFT:

                pic.load("resources/duckLeft.png");

                if (!colisionDetector.isCellAvailable(duck.getPosition(), DirectionType.LEFT)){
                    return;
                }

                //duck.setPic("resources/duckLeft.png");

                pic.translate(-moveLeft, 0);
                duck.getPosition().setCol(duck.getPosition().getCol() - 1);

                //pic.delete();
               // duck.setPic("resources/duckLeft.png");
                //pic = duck.getPicLeft();

                fieldOfVision.defog(DirectionType.LEFT);

                break;

            case KeyboardEvent.KEY_RIGHT:


                if (!colisionDetector.isCellAvailable(duck.getPosition(), DirectionType.RIGHT)){
                    return;
                }


                pic.load("resources/duckLookingLeft.png");
               // duck.setPic("resources/duckLookingLeft.png");

                pic.translate(moveRight, 0);
                duck.getPosition().setCol(duck.getPosition().getCol() + 1);

               //pic.delete();
               // duck.setPic("resources/duckLookingLeft.png");
               // pic = duck.getPicRight();

                fieldOfVision.defog(DirectionType.RIGHT);


                break;

            default:
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void setColisionDetector(ObstacleDetector colisionDetector) {
        this.colisionDetector = colisionDetector;
    }

    public void setFieldOfVision(FieldOfVision fieldOfVision) {
        this.fieldOfVision = fieldOfVision;
    }
}

