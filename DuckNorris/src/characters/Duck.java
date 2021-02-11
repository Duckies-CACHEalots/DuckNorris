package characters;

import coreInfo.Cell;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import layers.Grid;

public class Duck {

    private final int initialPosCol = 5;
    private final int initialPosRow = 12;
    private String name;
    private Cell position;
    private Picture pic;


    public Duck(String name){
        this.name = name;

        pic = new Picture( initialPosCol* Grid.CELLSIZE+Grid.PADDING,
                            initialPosRow*Grid.CELLSIZE+Grid.PADDING,
                            "resources/duckLeft.png");

        this.position = new Cell(initialPosCol,initialPosRow);
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

}
