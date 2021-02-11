package layers;

import coreInfo.Cell;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {


    public static final int CELLSIZE = 50;
    public static final int COLS = 30;
    public static final int ROWS = 18;
    public static final int PADDING = 10;


    private Obstacle obstacle;
    private Cell[][] coordinates; // array of cells that compose the grid
    private Picture background;


    public Grid() {
        background = new Picture(PADDING, PADDING, "resources/bg.jpeg");

        coordinates = new Cell[COLS][ROWS];

        for (int i = 0; i < COLS; i++) {
            for (int j = 0; j < ROWS; j++) {
                coordinates[i][j] = new Cell(i, j);
                coordinates[i][j].setRectangle(new Rectangle(i * CELLSIZE + PADDING, j * CELLSIZE + PADDING, CELLSIZE, CELLSIZE));
            }
        }

        obstacle = new Obstacle();

    }

    public void init() {
        background.draw();
        obstacle.creation();


    }


    public Cell[][] getCoordinates() {
        return coordinates;
    }






//------------***------------***------------***------------


    public class Obstacle {


        private void createObstacles(int col, int row) {
            coordinates[col][row].setObstacle(true);
        }


        private void creation() {

            //*** Obstacle list reviewed on Feb.9. It shows all obstacles on Rafa's design

            createObstacles(1, 13);
            createObstacles(1, 14);
            createObstacles(1, 15);
            createObstacles(1, 16);

            createObstacles(2, 1);
            createObstacles(2, 2);
            createObstacles(2, 3);
            createObstacles(2, 4);
            createObstacles(2, 5);
            createObstacles(2, 6);
            createObstacles(2, 7);
            createObstacles(2, 13);
            createObstacles(2, 16);

            createObstacles(3, 1);
            createObstacles(3, 7);
            createObstacles(3, 10);
            createObstacles(3, 11);
            createObstacles(3, 12);
            createObstacles(3, 13);
            createObstacles(3, 16);

            createObstacles(4, 1);
            createObstacles(4, 7);
            createObstacles(4, 10);
            createObstacles(4, 16);


            createObstacles(5, 0);
            createObstacles(5, 1);
            createObstacles(5, 2);
            createObstacles(5, 3);
            createObstacles(5, 4);
            createObstacles(5, 5);
            createObstacles(5, 7);
            createObstacles(5, 10);

            createObstacles(6, 5);
            createObstacles(6, 10);
            createObstacles(6, 11);
            createObstacles(6, 12);
            createObstacles(6, 13);
            createObstacles(6, 14);
            createObstacles(6, 15);
            createObstacles(6, 16);
            createObstacles(6, 17);

            createObstacles(7, 4);
            createObstacles(7, 5);
            createObstacles(7, 6);
            createObstacles(7, 7);

            createObstacles(8, 1);
            createObstacles(8, 4);
            createObstacles(8, 7);
            createObstacles(8, 8);
            createObstacles(8, 9);
            createObstacles(8, 10);
            createObstacles(8, 11);
            createObstacles(8, 12);
            createObstacles(8, 13);
            createObstacles(8, 14);
            createObstacles(8, 15);
            createObstacles(8, 16);

            createObstacles(9, 1);
            createObstacles(9, 4);
            createObstacles(9, 7);
            createObstacles(9, 11);
            createObstacles(9, 16);

            createObstacles(10, 1);
            createObstacles(10, 2);
            createObstacles(10, 3);
            createObstacles(10, 4);
            createObstacles(10, 5);
            createObstacles(10, 7);
            createObstacles(10, 11);
            createObstacles(10, 16);

            createObstacles(11, 16);

            createObstacles(12, 9);
            createObstacles(12, 10);
            createObstacles(12, 11);
            createObstacles(12, 12);
            createObstacles(12, 13);
            createObstacles(12, 14);


            createObstacles(13, 1);
            createObstacles(13, 2);
            createObstacles(13, 3);
            createObstacles(13, 4);
            createObstacles(13, 5);
            createObstacles(13, 6);
            createObstacles(13, 7);
            createObstacles(13, 9);
            createObstacles(13, 14);

            createObstacles(14, 1);
            createObstacles(14, 7);
            createObstacles(14, 9);
            createObstacles(14, 14);

            createObstacles(15, 1);
            createObstacles(15, 7);
            createObstacles(15, 8);
            createObstacles(15, 9);
            createObstacles(15, 14);
            createObstacles(15, 15);
            createObstacles(15, 16);
            createObstacles(15, 17);

            createObstacles(16, 1);
            createObstacles(16, 2);
            createObstacles(16, 3);
            createObstacles(16, 7);
            createObstacles(16, 9);

            createObstacles(17, 9);
            createObstacles(17, 10);
            createObstacles(17, 11);
            createObstacles(17, 12);
            createObstacles(17, 13);
            createObstacles(17, 14);
            createObstacles(17, 15);

            createObstacles(18, 1);
            createObstacles(18, 2);
            createObstacles(18, 3);
            createObstacles(18, 4);
            createObstacles(18, 5);
            createObstacles(18, 6);
            createObstacles(18, 7);
            createObstacles(18, 9);

            createObstacles(19, 4);
            createObstacles(19, 9);

            createObstacles(20, 4);
            createObstacles(20, 8);
            createObstacles(20, 9);
            createObstacles(20, 11);
            createObstacles(20, 12);
            createObstacles(20, 13);
            createObstacles(20, 14);
            createObstacles(20, 15);
            createObstacles(20, 16);

            createObstacles(21, 1);
            createObstacles(21, 2);
            createObstacles(21, 3);
            createObstacles(21, 4);
            createObstacles(21, 5);
            createObstacles(21, 6);
            createObstacles(21, 7);
            createObstacles(21, 11);

            createObstacles(22, 11);

            createObstacles(23, 11);

            createObstacles(24, 1);
            createObstacles(24, 2);
            createObstacles(24, 3);
            createObstacles(24, 4);
            createObstacles(24, 5);
            createObstacles(24, 6);
            createObstacles(24, 7);
            createObstacles(24, 11);
            createObstacles(24, 17);

            createObstacles(25, 1);
            createObstacles(25, 4);
            createObstacles(25, 7);
            createObstacles(25, 17);

            createObstacles(26, 1);
            createObstacles(26, 4);
            createObstacles(26, 7);
            createObstacles(26, 12);
            createObstacles(26, 13);
            createObstacles(26, 14);
            createObstacles(26, 17);

            createObstacles(27, 1);
            createObstacles(27, 7);
            createObstacles(27, 12);
            createObstacles(27, 14);
            createObstacles(27, 17);

            createObstacles(28, 12);
            createObstacles(28, 14);
            createObstacles(28, 15);
            createObstacles(28, 16);
            createObstacles(28, 17);


        }

    }

}
