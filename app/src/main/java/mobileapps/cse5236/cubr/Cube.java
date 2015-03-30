package mobileapps.cse5236.cubr;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Caitlin on 3/24/2015.
 */
public class Cube {
    private boolean isSolved;
    private int size;
    private CubeView cubeView;
    private ViewChanger viewChanger;
    //private final GameSession gameSession;

    public Cube() {
//        super(context, attributes);
//        this.gameSession = (GameSession) context;
//        setFocusable(true);
//        setFocusableInTouchMode(true);

        isSolved = false;
        size = 9;
        cubeView = new CubeView();
        viewChanger = new ViewChanger(cubeView);
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