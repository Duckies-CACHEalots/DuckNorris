import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Crocodile {

    private final int moveUP = Grid.CELLSIZE;
    private final int moveDown = Grid.CELLSIZE;
    private final int moveLeft = Grid.CELLSIZE;
    private final int moveRight = Grid.CELLSIZE;

    private String name;
    private final int length = 3;
    private Cell headPosition;
    private Cell[] positions;
    private Picture pic;
    private int width = length * Grid.CELLSIZE;
    private int height = Grid.CELLSIZE;
    private CrocodileDirectionType crocodileDirection;
    private DirectionType orientation;
    private ColisionDetector colisionDetector;
    private Grid grid;

    public Crocodile(String name, int col, int row, CrocodileDirectionType crocodileDirection){

        this.name = name;
        this.headPosition = new Cell(col, row);
        this.positions = new Cell[length];
        this.colisionDetector = new ColisionDetector();
        this.crocodileDirection = crocodileDirection;

        switch (crocodileDirection){

            case VERTICAL:
                setPic(new Picture(col * Grid.CELLSIZE + Grid.PADDING,
                        row * Grid.CELLSIZE + Grid.PADDING,
                        "resources/crocoUp.png"));
                break;
            case HORIZONTAL:
                setPic(new Picture(col * Grid.CELLSIZE + Grid.PADDING,
                    row * Grid.CELLSIZE + Grid.PADDING,
                    "resources/crocoLeft.png"));
                break;
        }
    }

    public void init(){
        if(crocodileDirection == CrocodileDirectionType.VERTICAL) {
            orientation = DirectionType.UP;
            positions[0] = headPosition;
            positions[1] = new Cell(headPosition.getCol(), headPosition.getRow() + 1);
            positions[2] = new Cell(headPosition.getCol(), headPosition.getRow() + 2);
        }
        else {
            orientation = DirectionType.LEFT;
            positions[0] = headPosition;
            positions[1] = new Cell(headPosition.getCol() + 1, headPosition.getRow());
            positions[2] = new Cell(headPosition.getCol() + 2 , headPosition.getRow());
        }

        pic.draw();
    }

    public void move() {

        switch (orientation){

            case UP:
                if(!colisionDetector.isCellAvailable(headPosition, DirectionType.UP)){
                    orientation = DirectionType.DOWN;
                    reverseDirection();
                    pic.load("resources/crocoDown.png");
                    return;
                }
                headPosition.setRow(headPosition.getRow() - 1);
                positions[0].setRow(headPosition.getRow());
                positions[1].setRow(headPosition.getRow() + 1);
                positions[2].setRow(headPosition.getRow() + 2);
                pic.translate(0, -moveUP);

                break;

            case DOWN:
                if(!colisionDetector.isCellAvailable(headPosition, DirectionType.DOWN)){
                    orientation = DirectionType.UP;
                    reverseDirection();
                    pic.load("resources/crocoUp.png");
                    return;
                }
                headPosition.setRow(headPosition.getRow() + 1);
                positions[0].setRow(headPosition.getRow());
                positions[1].setRow(headPosition.getRow() - 1);
                positions[2].setRow(headPosition.getRow() - 2);
                pic.translate(0, moveDown);

                break;

            case LEFT:
                if(!colisionDetector.isCellAvailable(headPosition, DirectionType.LEFT)){
                    orientation = DirectionType.RIGHT;
                    reverseDirection();
                    pic.load("resources/crocoRight.png");
                    return;
                }
                headPosition.setCol(headPosition.getCol() - 1);
                positions[0].setCol(headPosition.getCol());
                positions[1].setCol(headPosition.getCol() + 1);
                positions[2].setCol(headPosition.getCol() + 2);
                pic.translate(-moveLeft,0);

                break;

            case RIGHT:
                if(!colisionDetector.isCellAvailable(headPosition, DirectionType.RIGHT)){
                    orientation = DirectionType.LEFT;
                    reverseDirection();
                    pic.load("resources/crocoLeft.png");
                    return;
                }
                headPosition.setCol(headPosition.getCol() + 1);
                positions[0].setCol(headPosition.getCol());
                positions[1].setCol(headPosition.getCol() - 1);
                positions[2].setCol(headPosition.getCol() - 2);
                pic.translate(moveRight, 0);
        }
    }

    public void reverseDirection(){
        positions[0] = positions[2];
        positions[2] = headPosition;
        headPosition = positions[0];
    }

    public void setHeadPosition(Cell headPosition) {
        this.headPosition = headPosition;
    }

    public Cell getHeadPosition() {
        return headPosition;
    }

    public Cell[] getPositions() {
        return positions;
    }

    public String getName() {
        return name;
    }

    public void setPic(Picture pic) {
        this.pic = pic;
    }

    public Picture getPic() {
        return pic;
    }

    //----------------------------------------------

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public CrocodileDirectionType getCrocodileDirection() {
        return crocodileDirection;
    }

    public void setColisionDetector(ColisionDetector colisionDetector) {
        this.colisionDetector = colisionDetector;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }
}
