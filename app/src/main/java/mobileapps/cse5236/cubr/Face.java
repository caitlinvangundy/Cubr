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

    public Face(int index){
        isColorBlindOn = false;
        // TODO another list impl may be more beneficial
        rows = new ArrayList<Row>();
        columns = new ArrayList<Column>();
        size = 9;
    }

    public void rotateColumn(int index){

    }

    public void rotateRow(int index){

    }
}
