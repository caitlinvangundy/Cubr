package mobileapps.cse5236.cubr;

import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Caitlin on 3/24/2015.
 */
public class ViewChanger {
    private CubeView cubeView;
    private List<Button> views;

    public ViewChanger(CubeView cv){
        cubeView = cv;
        views = new ArrayList<Button>();
    }

    public void changeView(CubeView cubeView){

    }
}
