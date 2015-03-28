package mobileapps.cse5236.cubr;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Caitlin on 3/24/2015.
 */
public class Column {
    private int cubeCount;
    public List<Square> squares;

    public Column(int color, List<Square> squaresToAdd) {
        cubeCount = squaresToAdd.size();
        squares = new ArrayList<Square>(cubeCount);
        for (int i = 0; i < squaresToAdd.size(); i++) {
            squares.add(i, squaresToAdd.get(i));
        }
    }
}
