import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Duck {

    private String name;
    private Cell position;
    private Picture pic;
    private int initialPosCol = 0;
    private int initialPosRow = 0;

    public Duck(String name){
        this.name = name;
        setPic(new Picture(initialPosCol * Grid.CELLSIZE + Grid.PADDING,
                initialPosRow * Grid.CELLSIZE + Grid.PADDING,
                "resources/duckRight 50x50.png"));
        this.position = new Cell(initialPosCol, initialPosRow);
    }

    public void init(){
        pic.draw();
    }

    public void setPosition(Cell position) {
        this.position = position;
    }

    public Cell getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void setPic(Picture pic) {
        this.pic = pic;
    }

    public Picture getPic() {
        return pic;
    }

}
