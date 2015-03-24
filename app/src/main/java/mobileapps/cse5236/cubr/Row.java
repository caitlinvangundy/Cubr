package mobileapps.cse5236.cubr;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Caitlin on 3/24/2015.
 */
public class Row {
    private int cubeCount;
    private List<Square> squares;

    public Row(int colorIndex, int rowIndex){
        cubeCount = 2;
        squares = new ArrayList<Square>();
        int index;
        if (rowIndex == 0) index = 0;
        else index = 2;
        for(int i = 0; i < cubeCount; i++){
            squares.add(i, new Square(colorIndex, index+i));
        }
    }
}