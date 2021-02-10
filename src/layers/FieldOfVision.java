package layers;

import characters.DirectionType;
import coreInfo.Cell;

public class FieldOfVision {

    private int visibleCol = 5;
    private int visibleRow = 5;
    private Cell[][] defogScope; // array 5*5 where duck has light on
    private FogLayer fog;
    private Cell centerPos;
    private Cell duckPosition;
    private int cellToEdgeCol;
    private int cellToEdgeRow;
    private int topBorder;
    private int bottomBorder;
    private int leftBorder;
    private int rightBorder;
    //private Grid background;

    public FieldOfVision(FogLayer fog, Cell duckPosition) {

        this.fog = fog;

        this.duckPosition = duckPosition;
        defogScope = new Cell[visibleCol][visibleRow];

        cellToEdgeCol = (int) Math.floor(visibleCol / 2);    // it determines the middle cell of the scope.
        cellToEdgeRow = (int) Math.floor(visibleRow / 2);
    }

    public void init() {

        centerPos = duckPosition;
        recenterFieldOfVision();

        // creates all the cells based on the duck's location
        for (int i = 0; i < visibleCol; i++) {
            for (int j = 0; j < visibleRow; j++) {
                defogScope[i][j] = fog.getFog()[(duckPosition.getCol()) - cellToEdgeCol + i][duckPosition.getRow() - cellToEdgeRow + j];
                defogScope[i][j].setVisible();
                defogScope[i][j].getPicture().delete();
            }
        }
    }


    public void recenterFieldOfVision(){
        // defines the borders of the illumination scope
        topBorder = centerPos.getRow() - cellToEdgeRow;
        bottomBorder = centerPos.getRow() + cellToEdgeRow;
        leftBorder = centerPos.getCol() - cellToEdgeCol;
        rightBorder = centerPos.getCol() + cellToEdgeCol;
    }



    public void defog(DirectionType direction) throws ArrayIndexOutOfBoundsException{

        // initializes fov[0][0] on duck's position
        centerPos = duckPosition;
        recenterFieldOfVision(); // defines the borders of the scope

            switch (direction) {

                // all cases throw ArrayIndexOutOfBoundsException when they reach the edges using the keypressed method fully


                case UP:

                    topBorder--;
                    
                  for (int i = 0; i < visibleCol; i++) {
                        for (int j = 0; j < visibleRow; j++) {
                            defogScope[i][j] = fog.getFog()[leftBorder + i][topBorder + 1];
                        }
                    }
                    defoggingScope();
                    break;


                case DOWN:

                    topBorder++;

                    for (int i = 0; i < visibleCol; i++) {
                        for (int j = 0; j < visibleRow; j++) {
                            defogScope[i][j] = fog.getFog()[rightBorder - i][bottomBorder - j];
                        }
                    }
                    defoggingScope();
                    break;


                case LEFT:

                    leftBorder--;
                    for (int i = 0; i < visibleCol; i++) {
                        for (int j = 0; j < visibleRow; j++) {
                            defogScope[i][j] = fog.getFog()[leftBorder + 1][bottomBorder - j];
                        }
                    }
                    defoggingScope();
                    break;

                case RIGHT:
                    leftBorder++;

                    for (int i = 0; i < visibleCol; i++) {
                        for (int j = 0; j < visibleRow; j++) {
                            defogScope[i][j] = fog.getFog()[leftBorder + i][topBorder + j];
                        }
                        defoggingScope();
                    }
                    break;

            }
        }



    public void setCenterPos(Cell centerPos) {
        this.centerPos = centerPos;
    }


    public void defoggingScope(){
        for (int i = 0; i < visibleRow; i++) {
            for (int j = 0; j < visibleRow; j++) {
                if (!defogScope[i][j].isVisible()) {
                    defogScope[i][j].setVisible();
                    defogScope[i][j].getPicture().delete();
                }
            }

        }
    }
}
