package layers;

import characters.DirectionType;
import coreInfo.Cell;

public class FieldOfVision {

    private final int visibleCol = 5;
    private final int visibleRow = 5;
    private Cell[][] defogScope; // array 5*5
    private FogLayer fog;
    private Cell centerPos;
    private Cell duckPosition;
    private int cellToEdgeCol;
    private int cellToEdgeRow;
    private int topBorder;
    private int bottomBorder;
    private int leftBorder;
    private int rightBorder;

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
                defogScope[i][j].getRectangle().delete();
            }
        }
    }


    public void recenterFieldOfVision(){
        // defines the borders of the ilumination scope
        topBorder = centerPos.getRow() - cellToEdgeRow;
        bottomBorder = centerPos.getRow() + cellToEdgeRow;
        leftBorder = centerPos.getCol() - cellToEdgeCol;
        rightBorder = centerPos.getCol() + cellToEdgeCol;
    }

    public void defog(DirectionType direction) {
        // initializes fieldofvision[0][0] on duck's position
        centerPos = duckPosition;
        recenterFieldOfVision(); // defines the borders of the scope


        switch (direction) {

            // all cases throw ArrayIndexOutOfBoundsException when they reach the edges using the keypressed method fully, some fog squares remain
            

            case UP:

                  topBorder--;
/*
                  if (centerPos.getRow() == 0){
                      topBorder = 0;
                      for (int i = 0; i < visibleCol ; i++) {
                      }

                  }*/

                  if(bottomBorder == 0){
                      return;
                  }
                  for (int i = 0; i < visibleCol; i++) {        // for all cols on the scope of vision, move one to the left
                      for (int j = 0; j < visibleRow; j++) {    // ask pete logic behind this.
                          defogScope[i][j] = fog.getFog()[leftBorder + i][topBorder+1];
                      }
                  }
                  for (int i = 0; i < visibleRow; i++) {
                      defogScope[i][0].getRectangle().delete();
                  }
                  break;


            case DOWN:

                topBorder++;
                if(topBorder == fog.getGrid().MAX_HEIGHT){
                    return;
                }
                for (int i = 0; i < visibleCol; i++) {        
                    for (int j = 0; j < visibleRow; j++) {
                        defogScope[i][j] = fog.getFog()[rightBorder - i][bottomBorder - j];
                    }
                }
                for (int i = 0; i < visibleRow; i++) {
                    defogScope[i][0].getRectangle().delete();
                }
                break;



            case LEFT:          // keeps jumping a line it does not reach the end

                leftBorder--;
                if(leftBorder == 0){
                    return;
                }
                for (int i = 0; i < visibleCol; i++) {
                    for (int j = 0; j < visibleRow; j++) {
                        defogScope[i][j] = fog.getFog()[leftBorder + 1][bottomBorder-j];
                    }
                }
                for (int i = 0; i < visibleRow; i++) {
                    defogScope[0][i].getRectangle().delete();
                }
                break;

            case RIGHT:    // does not jump a line but it does not reach the end of the laberynth
                leftBorder++;
                if(leftBorder == fog.getGrid().MAX_WIDTH+1){
                    return;
                }
                for (int i = 0; i < visibleCol; i++) {
                    for (int j = 0; j < visibleRow; j++) {
                        defogScope[i][j] = fog.getFog()[leftBorder + i][topBorder + j];
                    }
                }
                for (int i = 0; i < visibleRow; i++) {
                    defogScope[visibleRow-2][i].getRectangle().delete();
                }
                break;

        }

    }


    public void setCenterPos(Cell centerPos) {
        this.centerPos = centerPos;
    }

}
