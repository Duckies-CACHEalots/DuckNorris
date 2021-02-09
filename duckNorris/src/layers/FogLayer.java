package layers;

import coreInfo.Cell;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class FogLayer {

    private Cell[][] fog;
    private Grid grid;

    public FogLayer(Grid grid){

        this.grid = grid;

        // creates layer of fog, covers the entire gameboard
        fog = new Cell[grid.getCols()][grid.getRows()];
        for (int i = 0; i < grid.getCols(); i++) {
            for (int j = 0; j < grid.getRows() ; j++) {
                fog[i][j] = new Cell(i,j);
                fog[i][j].setRectangle(new Rectangle(i * Grid.CELLSIZE + Grid.PADDING, j * Grid.CELLSIZE + Grid.PADDING, Grid.CELLSIZE, Grid.CELLSIZE));
                fog[i][j].getRectangle().setColor(Color.LIGHT_GRAY);
            }
        }


    }

    public void init (){
        for (int i = 0; i < grid.getCols() ; i++) { // initializes fog layer
            for (int j = 0; j < grid.getRows(); j++) {
                fog[i][j].getRectangle().fill();
            }
        }




    }


    public Cell[][] getFog() {
        return fog;
    }

    public Grid getGrid() {
        return grid;

    }

    public void setFog(Cell[][] fog) {
        this.fog = fog;
    }
}
