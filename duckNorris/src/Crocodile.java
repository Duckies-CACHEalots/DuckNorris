import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Crocodile {

    private final int moveUP = Grid.CELLSIZE;
    private final int moveDown = Grid.CELLSIZE;
    private final int moveLeft = Grid.CELLSIZE;
    private final int moveRight = Grid.CELLSIZE;

    private String name;
    private Cell position;
    private Picture pic;
    private int width = 3 * Grid.CELLSIZE;
    private int height = 1 * Grid.CELLSIZE;
    private CrocodileDirectionType crocodileDirection;
    private DirectionType orientation;
    private ColisionDetector colisionDetector;
    private Grid grid;

    public Crocodile(String name, int col, int row, CrocodileDirectionType crocodileDirection){
        this.name = name;
        setPic(new Picture(col * Grid.CELLSIZE + Grid.PADDING,
                row * Grid.CELLSIZE + Grid.PADDING,
                "resources/duckLeft 50x50.png"));
        this.position = new Cell(col, row);
        this.crocodileDirection = crocodileDirection;
        this.colisionDetector = new ColisionDetector();
    }

    public void init(){
        if(crocodileDirection == CrocodileDirectionType.VERTICAL) {
            orientation = DirectionType.UP;
        }
        else {
            orientation = DirectionType.LEFT;
        }

        pic.draw();
    }

    public void move() {

        switch (orientation){

            case UP:
                if(!colisionDetector.isCellAvailable(position, DirectionType.UP)){
                    orientation = DirectionType.DOWN;
                    return;
                }
                position.setRow(position.getRow() - 1);
                pic.translate(0, -moveUP);
                break;

            case DOWN:
                if(!colisionDetector.isCellAvailable(position, DirectionType.DOWN)){
                    orientation = DirectionType.UP;
                    return;
                }
                position.setRow(position.getRow() + 1);
                pic.translate(0, moveDown);

                break;

            case LEFT:
                if(!colisionDetector.isCellAvailable(position, DirectionType.LEFT)){
                    orientation = DirectionType.RIGHT;
                    return;
                }
                position.setCol(position.getCol() - 1);
                pic.translate(-moveLeft,0);

                break;

            case RIGHT:
                if(!colisionDetector.isCellAvailable(position, DirectionType.RIGHT)){
                    orientation = DirectionType.LEFT;
                    return;
                }
                position.setCol(position.getCol() + 1);
                pic.translate(moveRight, 0);


        }
    }



    public void setPosition(Cell position) {
        this.position = position;
    }

    public Cell getPosition() {
        return position;
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
