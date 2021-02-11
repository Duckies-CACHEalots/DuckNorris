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
    private Picture picRight;
    private Picture picDown;
    private Picture picUp;
    private Picture picLeft;
    private String duckName;



    public Duck(String name){
        this.name = name;

        //this.duckName = setPic("resources/duckLeft.png");

        pic = new Picture( initialPosCol* Grid.CELLSIZE+Grid.PADDING,
                            initialPosRow*Grid.CELLSIZE+Grid.PADDING,
                            "resources/duckLeft.png");


       /* picLeft = new Picture( initialPosCol* Grid.CELLSIZE+Grid.PADDING,
                initialPosRow*Grid.CELLSIZE+Grid.PADDING,
                "resources/duckLeft.png");

        picRight = new Picture( initialPosCol* Grid.CELLSIZE+Grid.PADDING,
                initialPosRow*Grid.CELLSIZE+Grid.PADDING,
                "resources/duckLookingLeft.png");

        picDown = new Picture( initialPosCol* Grid.CELLSIZE+Grid.PADDING,
                initialPosRow*Grid.CELLSIZE+Grid.PADDING,
                "resources/duckDown.png");

        picUp = new Picture( initialPosCol* Grid.CELLSIZE+Grid.PADDING,
                initialPosRow*Grid.CELLSIZE+Grid.PADDING,
                "resources/duckUp.png"); */


        this.position = new Cell(initialPosCol,initialPosRow);
    }

    public void init(){

            pic.draw();
           /* setPic(pic);
            pic.draw();

            setPic(picRight);
            picRight.draw();

            setPic(picDown);
            picDown.draw();

            setPic(picUp);
            picUp.draw(); */
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
       //this.duckName = duckName;
       return duckName;
    }
    public Picture getPic() {
        return pic;
    }

  /*  public void setPicUp() {
        picUp.draw();
        this.pic = picUp;
    }

    public Picture getPicUp() {
        return picUp;
    }

    public void setPicDown() {
        picDown.draw();
        this.pic = picDown;
    }

    public Picture getPicDown() {
        return picDown;
    }

    public void setPicLeft() {
        picLeft.draw();
        this.pic = picLeft;
    }

    public Picture getPicLeft() {
        return picLeft;
    }

    public void setPicRight() {
        picRight.draw();
        this.pic = picRight;
    }

    public Picture getPicRight() {
        return picRight;
    }*/



}
