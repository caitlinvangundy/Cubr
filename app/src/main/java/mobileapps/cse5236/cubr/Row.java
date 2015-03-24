package mobileapps.cse5236.cubr;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Caitlin on 3/24/2015.
 */
public class Row {
    private int cubeCount;
    private List<Square> squares;

    public Row(){
        cubeCount = 3;
        squares = new ArrayList<Square>();
    }
}