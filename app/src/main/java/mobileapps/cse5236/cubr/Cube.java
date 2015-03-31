package mobileapps.cse5236.cubr;

/**
 * Created by Caitlin on 3/24/2015.
 */
public class Cube {
    private int size;
    private CubeView cubeView;;

    public Cube() {
        size = 4;
        cubeView = new CubeView();
    }

    public void rotateColumn(int index, String direction) {
        cubeView.rotateColumn(index, direction);
    }

    public void rotateRow(int index, String direction) {
        cubeView.rotateRow(index, direction);
    }

    public void changeView(Face clickedFace) {
        cubeView.changeView(clickedFace);
    }

    public CubeView getCubeView(){
        return cubeView;
    }

}