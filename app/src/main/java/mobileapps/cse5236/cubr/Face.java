package mobileapps.cse5236.cubr;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Caitlin on 3/24/2015.
 */
public class Face {
    public List<Row> rows;
    private int size;
    public int faceIndex;

    public Face(int colorIndex) {
        faceIndex = colorIndex;
        size = 2;
        rows = new ArrayList<Row>();
        for (int i = 0; i < size; i++) {
            rows.add(i, new Row(colorIndex));
        }
    }

    public void rotateClockwise() {
        Square topLeft = rows.get(0).squares.get(0);
        Square topRight = rows.get(0).squares.get(1);
        Square bottomLeft = rows.get(1).squares.get(0);
        Square bottomRight = rows.get(1).squares.get(1);

        rows.get(0).squares.set(0, bottomLeft);
        rows.get(0).squares.set(1, topLeft);
        rows.get(1).squares.set(0, bottomRight);
        rows.get(1).squares.set(1, topRight);
    }

    public void rotateCounterClockwise() {
        Square topLeft = rows.get(0).squares.get(0);
        Square topRight = rows.get(0).squares.get(1);
        Square bottomLeft = rows.get(1).squares.get(0);
        Square bottomRight = rows.get(1).squares.get(1);

        rows.get(0).squares.set(0, topRight);
        rows.get(0).squares.set(1, bottomRight);
        rows.get(1).squares.set(0, topLeft);
        rows.get(1).squares.set(1, bottomLeft);
    }

    public int getFaceIndex() {
        return faceIndex;
    }

    public String getType() {
        switch (faceIndex) {
            case 0:
                return "Current";
            case 1:
                return "Right";
            case 2:
                return "Back";
            case 3:
                return "Left";
            case 4:
                return "Top";
            case 5:
                return "Bottom";
        }
        return null;
    }
}
