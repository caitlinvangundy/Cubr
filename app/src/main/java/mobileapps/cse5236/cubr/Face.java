package mobileapps.cse5236.cubr;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Caitlin on 3/24/2015.
 */
public class Face {
    private boolean isColorBlindOn;
    private List<Row> rows;
    private List<Column> columns;
    private int size;

    public Face(int colorIndex){
        size = 2;
        isColorBlindOn = false;
        rows = new ArrayList<Row>();
        columns = new ArrayList<Column>();
        for  (int i = 0; i < size; i++){
            rows.add(i, new Row(colorIndex, i));
        }
        // TODO Setup columns
    }

    public void rotateColumn(int index){

    }

    public void rotateRow(int index){

    }
}
