package mobileapps.cse5236.cubr;

/**
 * Created by Caitlin on 3/24/2015.
 */
public class Cube {
    private boolean isSolved;
    private int size;
    private CubeView cubeView;
    private ViewChanger viewChanger;

    public Cube(){
        isSolved = false;
        size = 9;
        cubeView = new CubeView();
        viewChanger = new ViewChanger(cubeView);
    }

    public void rotateColumn(int index){
        cubeView.rotateColumn(index);
    }

    public void rotateRow(int index){
        cubeView.rotateRow(index);
    }

    public void  changeView(Face clickedFace){
        cubeView.changeView(clickedFace);
    }
}
