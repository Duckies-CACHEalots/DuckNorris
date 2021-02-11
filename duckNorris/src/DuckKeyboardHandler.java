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
    private ColisionDetector colisionDetector;



    public DuckKeyboardHandler(Duck duck){
        this.duck = duck;
        this.pic = duck.getPic();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {



        switch (keyboardEvent.getKey()){


           // case KeyboardEvent.KEY_S:
                //game/Game.startpic.delete();

            case KeyboardEvent.KEY_UP:
                if (!colisionDetector.isCellAvailable(duck.getPosition(), DirectionType.UP)){
                    return;
                }
                pic.translate(0, -moveUP);
                duck.getPosition().setRow(duck.getPosition().getRow() - 1);
                break;
            case KeyboardEvent.KEY_DOWN:
                if (!colisionDetector.isCellAvailable(duck.getPosition(), DirectionType.DOWN)){
                    return;
                }
                pic.translate(0, moveDown);
                duck.getPosition().setRow(duck.getPosition().getRow() + 1);
                break;
            case KeyboardEvent.KEY_LEFT:
                if (!colisionDetector.isCellAvailable(duck.getPosition(), DirectionType.LEFT)){
                    return;
                }
                pic.translate(-moveLeft, 0);
                duck.getPosition().setCol(duck.getPosition().getCol() - 1);
                break;
            case KeyboardEvent.KEY_RIGHT:
                if (!colisionDetector.isCellAvailable(duck.getPosition(), DirectionType.RIGHT)){
                    return;
                }
                pic.translate(moveRight, 0);
                duck.getPosition().setCol(duck.getPosition().getCol() + 1);
                break;
            default:
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void setColisionDetector(ColisionDetector colisionDetector) {
        this.colisionDetector = colisionDetector;
    }
}
