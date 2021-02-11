package layers;

import coreInfo.Cell;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.w3c.dom.css.Rect;

public class FogLayer {

    private Cell[][] fog;

    public FogLayer(){

        // creates layer of fog, covers the entire gameboard
        fog = new Cell[Grid.COLS][Grid.ROWS];
        for (int i = 0; i < Grid.COLS; i++) {
            for (int j = 0; j < Grid.ROWS ; j++) {
                fog[i][j] = new Cell(i,j);
                fog[i][j].setPicture(new Picture(i * Grid.CELLSIZE + Grid.PADDING, j * Grid.CELLSIZE + Grid.PADDING, "resources/chuck.png"));



            }
        }

    }

    public void init (){
        for (int i = 0; i < Grid.COLS ; i++) { // initializes fog layer
            for (int j = 0; j < Grid.ROWS; j++) {
                fog[i][j].getPicture().draw();

            }
        }




    }

    public Cell[][] getFog() {
        return fog;
    }



}
