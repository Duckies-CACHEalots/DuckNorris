package layers;

import characters.DirectionType;
import characters.Duck;
import coreInfo.Cell;

public class FieldOfVision {

    private int visibleCol = 5;
    private int visibleRow = 5;
    private Cell[][] defogScope;  // array 3*3 where duck has light on
    private FogLayer fog;
    private Cell duckPosition;
    private int cellToEdgeCol;
    private int cellToEdgeRow;
    private int topBorder;
    private int leftBorder;

    public FieldOfVision(FogLayer fog, Cell duckPosition) {

        this.fog = fog;

        this.duckPosition = duckPosition;
        defogScope = new Cell[visibleCol][visibleRow];

        cellToEdgeCol = (int) Math.floor(visibleCol / 2);    // it determines the middle cell of the scope.
        cellToEdgeRow = (int) Math.floor(visibleRow / 2);
    }

    public void init() {

        recenterFieldOfVision();

        // creates all the cells based on the duck's location
        for (int i = 0; i < visibleCol; i++) {
            for (int j = 0; j < visibleRow; j++) {
                //defogScope[i][j] = fog.getFog()[(duckPosition.getCol()) - cellToEdgeCol + i][duckPosition.getRow() - cellToEdgeRow + j];
                defogScope[i][j] = fog.getFog()[Duck.initialPosCol - cellToEdgeCol + i][Duck.initialPosRow - cellToEdgeRow + j];
                defogScope[i][j].setVisible();
                defogScope[i][j].getPicture().delete();
            }
        }
    }


    public void recenterFieldOfVision() {
        // defines the borders of the illumination scope
        topBorder = duckPosition.getRow() - cellToEdgeRow;
        topBorder = topBorder < 0 ? 0 : topBorder;
        topBorder = topBorder > (Grid.ROWS - visibleRow) ? Grid.ROWS - visibleRow : topBorder;

        leftBorder = duckPosition.getCol() - cellToEdgeCol;
        leftBorder = leftBorder < 0 ? 0 : leftBorder;
        leftBorder = leftBorder > (Grid.COLS - visibleCol) ? Grid.COLS - visibleCol : leftBorder;
    }


    public void defog(DirectionType direction) {

        recenterFieldOfVision();

        defoggingScope();
    }


    public void restartBorders(){
        topBorder = Duck.initialPosRow; // - cellToEdgeRow;
        leftBorder = Duck.initialPosCol; // - cellToEdgeCol;
    }

    public void defoggingScope() {

        for (int i = 0; i < visibleCol; i++) {
            for (int j = 0; j < visibleRow; j++) {
                defogScope[i][j] = fog.getFog()[leftBorder + i][topBorder + j];
            }
        }

        for (int i = 0; i < visibleCol; i++) {
            for (int j = 0; j < visibleRow; j++) {
                if (!defogScope[i][j].isVisible()) {
                    defogScope[i][j].setVisible();
                    defogScope[i][j].getPicture().delete();
                }
            }
        }
    }

}


