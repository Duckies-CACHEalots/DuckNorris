import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Duck {

    private String name;
    private Cell position;
    private Picture pic;
    private int initialPosCol = 7;
    private int initialPosRow = 0;
    private int lives;
    private final int NUMBEROFLIVES = 3;

    public Duck(String name){
        this.name = name;
        setPic(new Picture(initialPosCol * Grid.CELLSIZE + Grid.PADDING,
                initialPosRow * Grid.CELLSIZE + Grid.PADDING,
                "resources/duckRight 50x50.png"));
        this.position = new Cell(initialPosCol, initialPosRow);
        this.lives = NUMBEROFLIVES;
    }

    public void goToInitialPosition(){
        int posXI = position.getCol() * Grid.CELLSIZE + Grid.PADDING;
        int posYI = position.getRow() * Grid.CELLSIZE + Grid.PADDING;
        this.position = new Cell(initialPosCol, initialPosRow);
        int posXF = position.getCol() * Grid.CELLSIZE + Grid.PADDING;
        int posYF = position.getRow() * Grid.CELLSIZE + Grid.PADDING;
        pic.translate(posXF - posXI, posYF - posYI);
        pic.draw();
    }

    public void init(){
        pic.draw();
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

    public void decreaseLives(){
        this.lives = --lives;
    }

    public int getLives() {
        return lives;
    }
}
