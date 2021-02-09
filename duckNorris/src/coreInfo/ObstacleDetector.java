package coreInfo;

import characters.DirectionType;
import layers.Grid;

public class ObstacleDetector {

    private Grid grid;

    public ObstacleDetector(Grid grid){
        this.grid = grid;
    }


    public boolean checkCollision(Cell c1, Cell c2){
        return  c1.equals(c2);
    }


    public boolean isCellAvailable(Cell currentPosition, DirectionType direction) {

        switch (direction){

            case UP:
                if(currentPosition.getRow() == 0){
                    return false;
                }
                if(grid.getCoordinates()[currentPosition.getCol()][currentPosition.getRow() - 1].isObstacle()){
                    return false;
                }
                break;


            case DOWN:
                if(currentPosition.getRow() == grid.getRows() - 1){
                    return false;
                }
                if(grid.getCoordinates()[currentPosition.getCol()][currentPosition.getRow() + 1].isObstacle()){
                    return false;
                }
                break;

            case LEFT:
                if(currentPosition.getCol() == 0){
                    return false;
                }
                if(grid.getCoordinates()[currentPosition.getCol() - 1][currentPosition.getRow()].isObstacle()){
                    return false;
                }
                break;

            case RIGHT:
                if(currentPosition.getCol() == grid.getCols() - 1){
                    return false;
                }
                if(grid.getCoordinates()[currentPosition.getCol() + 1][currentPosition.getRow()].isObstacle()){
                    return false;
                }
                break;
        }
        return true;
    }

    public boolean nextUpCell(Cell origin){
        if(origin.getRow() == 0){
            return false;
        }
        //if(origin.getRow() ){

        //}
        // origin.getRow()-1
        return true;
    }


}
