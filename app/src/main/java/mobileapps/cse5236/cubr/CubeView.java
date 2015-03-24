package mobileapps.cse5236.cubr;

/**
 * Created by Caitlin on 3/24/2015.
 */
public class CubeView {
    private Face currentFace;
    private Face backFace;
    private Face leftFace;
    private Face rightFace;
    private Face bottomFace;
    private Face topFace;

    public CubeView(){
        currentFace = new Face(0);
        rightFace = new Face(1);
        backFace = new Face(2);
        leftFace = new Face(3);
        topFace = new Face(4);
        bottomFace = new Face(5);
    }

    public void rotateColumn(int index){
        currentFace.rotateColumn(index);
    }

    public void rotateRow(int index){
        currentFace.rotateRow(index);
    }

    public void changeView(Face clickedFace){

    }
}
