package characters;

import coreInfo.ObstacleDetector;
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


    public DuckKeyboardHandler(Duck duck){
        this.duck = duck;
        pic = duck.getPic();
        duck.setPic("resources/duckLeft.png");
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_UP:


               if (!colisionDetector.isCellAvailable(duck.getPosition(), DirectionType.UP)){
                    return;
               }

                duck.setPic("resources/duckUp.png");

                pic.translate(0, -moveUP);
                duck.getPosition().setRow(duck.getPosition().getRow() - 1);

                //pic.delete();
                duck.setPic("resources/duckUp.png");
               // pic = duck.getPicUp();

               // if ()//need to check if next cells are visible, if they are there's no need to call defog.

                fieldOfVision.defog(DirectionType.UP);

                break;
            case KeyboardEvent.KEY_DOWN:

               if (!colisionDetector.isCellAvailable(duck.getPosition(), DirectionType.DOWN)){
                    return;
                }

                duck.setPic("resources/duckDown.png");

                pic.translate(0, moveDown);
                duck.getPosition().setRow(duck.getPosition().getRow() + 1);

               // pic.delete();
                duck.setPic("resources/duckDown.png");
                //pic = duck.getPicDown();

                fieldOfVision.defog(DirectionType.DOWN);

                break;
            case KeyboardEvent.KEY_LEFT:

                if (!colisionDetector.isCellAvailable(duck.getPosition(), DirectionType.LEFT)){
                    return;
                }

                duck.setPic("resources/duckLeft.png");

                pic.translate(-moveLeft, 0);
                duck.getPosition().setCol(duck.getPosition().getCol() - 1);

                //pic.delete();
                duck.setPic("resources/duckLeft.png");
                //pic = duck.getPicLeft();

                fieldOfVision.defog(DirectionType.LEFT);

                break;
            case KeyboardEvent.KEY_RIGHT:


                if (!colisionDetector.isCellAvailable(duck.getPosition(), DirectionType.RIGHT)){
                    return;
                }

                duck.setPic("resources/duckLookingLeft.png");

                pic.translate(moveRight, 0);
                duck.getPosition().setCol(duck.getPosition().getCol() + 1);

               //pic.delete();
                duck.setPic("resources/duckLookingLeft.png");
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

