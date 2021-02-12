package characters;

import coreInfo.Cell;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import layers.Grid;

public class Duck {

    public static final int initialPosCol = 4;
    public static final int initialPosRow = 12;
    private String name;
    private Cell position;
    private Picture pic;
    private int lives;
    private final int NUMBEROFLIVES = 3;


    public Duck(String name){
        this.name = name;

        pic = new Picture( initialPosCol* Grid.CELLSIZE+Grid.PADDING,
                            initialPosRow*Grid.CELLSIZE+Grid.PADDING,
                            "resources/duckDown.png");

        this.position = new Cell(initialPosCol,initialPosRow);
        this.lives = NUMBEROFLIVES;
    }

    public void goToInitialPosition(){
        int posDeathX = position.getCol() * Grid.CELLSIZE + Grid.PADDING;
        int posDeathY = position.getRow() * Grid.CELLSIZE + Grid.PADDING;

        this.position.setCol(initialPosCol);
        this.position.setRow(initialPosRow);

        int posStartX = initialPosCol * Grid.CELLSIZE + Grid.PADDING;
        int posStartY = initialPosRow * Grid.CELLSIZE + Grid.PADDING;

        pic.translate(posStartX - posDeathX, posStartY - posDeathY - 1);
        pic.load("resources/duckDown.png");
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


    public String setPic(String duckName){
       return duckName;
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

    public int getInitialPosCol() {
        return initialPosCol;
    }

    public int getInitialPosRow() {
        return initialPosRow;
    }
}
