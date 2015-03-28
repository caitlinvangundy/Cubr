package mobileapps.cse5236.cubr;

import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Caitlin on 3/24/2015.
 */
public class ViewChanger implements View.OnClickListener {
    private CubeView cubeView;
    private List<Button> views;

    public ViewChanger(CubeView cv) {
        cubeView = cv;
        views = new ArrayList<Button>();
    }

    public void changeView(Face clickedFace) {
        cubeView.changeView(clickedFace);
    }

    @Override
    public void onClick(View v) {
        // TODO Need to implement the view changer UI component to get access to the R.id'ss
//        switch(v.getId()) {
//            case R.id.topFace:
//                changeView(cubeView.getTopFace());
//                break;
//            case R.id.leftFace:
//                changeView(cubeView.getLeftFace());
//                break;
//            case R.id.bottomFace:
//                changeView(cubeView.getBottomFace());
//                break;
//            case R.id.rightFace:
//                changeView(cubeView.getRightFace());
//                break;
//        }
    }
}
