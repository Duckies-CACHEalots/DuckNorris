public class ColisionDetector {

    private Grid grid;
    private Duck duck;
    private Crocodile[] crocodiles;


    public ColisionDetector(){

    }


    public ColisionDetector(Grid grid){
        this.grid = grid;
    }


    public boolean checkCollision(Cell currentPosition, Cell target){
        return  currentPosition.equals(target);
    }

    public boolean checkCollision(Cell currentPosition, Cell[] targets){
        boolean result = false;

        for(Cell target : targets){
            result = result || checkCollision(currentPosition, target);
        }
        return result;
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



    public void setDuck(Duck duck) {
        this.duck = duck;
    }

    public Duck getDuck() {
        return duck;
    }

    public void setCrocodiles(Crocodile[] crocodiles) {
        this.crocodiles = crocodiles;
    }

    public Crocodile[] getCrocodiles() {
        return crocodiles;
    }
}
