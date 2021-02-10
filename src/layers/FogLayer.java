package layers;

import coreInfo.Cell;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.w3c.dom.css.Rect;

public class FogLayer {

    private Cell[][] fog;
    private Grid grid;
    private Picture fogOfWar;


    public FogLayer(Grid grid){

        this.grid = grid;

        // creates layer of fog, covers the entire gameboard
        fog = new Cell[grid.getCols()][grid.getRows()];
        for (int i = 0; i < grid.getCols(); i++) {
            for (int j = 0; j < grid.getRows() ; j++) {
                fog[i][j] = new Cell(i,j);
                //fog[i][j].setRectangle(new Rectangle(i * Grid.CELLSIZE + Grid.PADDING, j * Grid.CELLSIZE + Grid.PADDING, Grid.CELLSIZE, Grid.CELLSIZE));
                fog[i][j].setPicture(new Picture(i * Grid.CELLSIZE + Grid.PADDING, j * Grid.CELLSIZE + Grid.PADDING, "resources/chuck.png"));
                //fog[i][j].getRectangle().setColor(Color.RED);


            }
        }

    }

    public void init (){
        for (int i = 0; i < grid.getCols() ; i++) { // initializes fog layer
            for (int j = 0; j < grid.getRows(); j++) {
                fog[i][j].getPicture().draw();

            }
        }




    }

    public Cell[][] getFog() {
        return fog;
    }



}
