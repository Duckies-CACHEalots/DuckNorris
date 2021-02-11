package characters;

import coreInfo.Cell;
import layers.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Duck {

    private final int initialPosCol = 15; // aqui tiene que ir 2
    private final int initialPosRow = 10; // aqui tiene que ir 9
    private String name;
    private Cell position;
    private Picture pic;



    public Duck(String name){
        this.name = name;
        setPic(new Picture( initialPosCol* Grid.CELLSIZE+Grid.PADDING,
                            initialPosRow*Grid.CELLSIZE+Grid.PADDING,
                            "resources/duckLeft.png"));

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

    public void setPic(Picture pic) {
        this.pic = pic;
    }

    public Picture getPic() {
        return pic;
    }




}
