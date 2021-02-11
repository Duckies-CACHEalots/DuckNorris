package coreInfo;

import characters.DirectionType;
import layers.Grid;

public class CollisionDetector {

    private Grid grid;

    public CollisionDetector(Grid grid){
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
                if(currentPosition.getRow() == Grid.ROWS - 1){
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
                if(currentPosition.getCol() == Grid.COLS - 1){
                    return false;
                }
                if(grid.getCoordinates()[currentPosition.getCol() + 1][currentPosition.getRow()].isObstacle()){
                    return false;
                }
                break;
        }
        return true;
    }



}
