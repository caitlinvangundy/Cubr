package mobileapps.cse5236.cubr;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Caitlin on 3/24/2015.
 */
public class Face {
    private boolean isColorBlindOn;
    public List<Row> rows;
    public List<Column> columns;
    private int size;
    private int faceIndex;

    public Face(int colorIndex) {
        faceIndex = colorIndex;
        size = 2;
        isColorBlindOn = false;
        rows = new ArrayList<Row>();
        for (int i = 0; i < size; i++) {
            rows.add(i, new Row(colorIndex, i));
        }

        setupColumns(colorIndex);
    }

    private void setupColumns(int colorIndex) {
        columns = new ArrayList<Column>();
        List<Square> leftSquares = new ArrayList<Square>(size);
        leftSquares.add(0, rows.get(0).squares.get(0));
        leftSquares.add(1, rows.get(1).squares.get(0));
        Column left = new Column(colorIndex, leftSquares);

        List<Square> rightSquares = new ArrayList<Square>(size);
        rightSquares.add(0, rows.get(0).squares.get(1));
        rightSquares.add(1, rows.get(1).squares.get(1));
        Column right = new Column(colorIndex, rightSquares);

        columns.add(0, left);
        columns.add(1, right);
    }

    public void rotateClockwise() {
        Square topLeft = rows.get(0).squares.get(0); // 1
        Square topRight = rows.get(0).squares.get(1); // 2
        Square bottomLeft = rows.get(1).squares.get(0); // 3
        Square bottomRight = rows.get(1).squares.get(1); // 4

        rows.set(0, rows.get(0)).squares.set(0, bottomLeft);
        rows.set(0, rows.get(0)).squares.set(1, topLeft);
        rows.set(0, rows.get(1)).squares.set(0, bottomRight);
        rows.set(0, rows.get(1)).squares.set(1, topRight);
    }

    public void rotateCounterClockwise() {
        Square topLeft = rows.get(0).squares.get(0); // 1
        Square topRight = rows.get(0).squares.get(1); // 2
        Square bottomLeft = rows.get(1).squares.get(0); // 3
        Square bottomRight = rows.get(1).squares.get(1); // 4

        rows.set(0, rows.get(0)).squares.set(0, topRight);
        rows.set(0, rows.get(0)).squares.set(1, bottomRight);
        rows.set(0, rows.get(1)).squares.set(0, topLeft);
        rows.set(0, rows.get(1)).squares.set(1, bottomLeft);
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
