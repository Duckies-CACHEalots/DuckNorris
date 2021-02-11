package characters;

import coreInfo.CollisionDetector;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import layers.Grid;
import layers.FieldOfVision;

public class DuckKeyboardHandler implements KeyboardHandler {

    private final int moveUP = Grid.CELLSIZE;
    private final int moveDown = Grid.CELLSIZE;
    private final int moveLeft = Grid.CELLSIZE;
    private final int moveRight = Grid.CELLSIZE;

    private Duck duck;
    private Picture pic;
    private CollisionDetector collisionDetector;
    private FieldOfVision fieldOfVision;
    private Picture startpic;


    public DuckKeyboardHandler(Duck duck, Picture startpic){
        this.duck = duck;
        this.pic = duck.getPic();
        this.startpic = startpic;
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()){

            case KeyboardEvent.KEY_S:
                startpic.delete();

            case KeyboardEvent.KEY_UP:

            pic.load("resources/duckUp.png");

               if (!collisionDetector.isCellAvailable(duck.getPosition(), DirectionType.UP)){
                    return;
               }
                pic.translate(0, -moveUP);
                duck.getPosition().setRow(duck.getPosition().getRow() - 1);
                fieldOfVision.defog(DirectionType.UP);
                break;

            case KeyboardEvent.KEY_DOWN:
                pic.load("resources/duckDown.png");
               if (!collisionDetector.isCellAvailable(duck.getPosition(), DirectionType.DOWN)){
                    return;
                }
                pic.translate(0, moveDown);
                duck.getPosition().setRow(duck.getPosition().getRow() + 1);
                fieldOfVision.defog(DirectionType.DOWN);
                break;

            case KeyboardEvent.KEY_LEFT:
                pic.load("resources/duckLeft.png");
                if (!collisionDetector.isCellAvailable(duck.getPosition(), DirectionType.LEFT)){
                    return;
                }

                pic.translate(-moveLeft, 0);
                duck.getPosition().setCol(duck.getPosition().getCol() - 1);
                fieldOfVision.defog(DirectionType.LEFT);
                break;

            case KeyboardEvent.KEY_RIGHT:
                if (!collisionDetector.isCellAvailable(duck.getPosition(), DirectionType.RIGHT)){
                    return;
                }
                pic.load("resources/duckLookingLeft.png");
                pic.translate(moveRight, 0);
                duck.getPosition().setCol(duck.getPosition().getCol() + 1);
                fieldOfVision.defog(DirectionType.RIGHT);
                break;

            default:
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void setObstacleDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }

    public void setFieldOfVision(FieldOfVision fieldOfVision) {
        this.fieldOfVision = fieldOfVision;
    }
}

