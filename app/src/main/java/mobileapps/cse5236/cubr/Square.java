package mobileapps.cse5236.cubr;

import android.graphics.Color;
import android.media.Image;
import android.widget.ImageView;

import java.util.HashMap;

/**
 * Created by Caitlin on 3/24/2015.
 */
public class Square {
    private HashMap<Integer, Integer> colorMap;
    private int squareId;
    public int color;
    private Image image;
    private boolean isColorBlindOn;
    public ImageView imageView;

    public Square(int colorIndex, int squareIndex) {
        squareId = squareIndex;
        color = colorIndex;

        colorMap = new HashMap<Integer, Integer>();
        colorMap.put(0, Color.RED);
        colorMap.put(1, Color.MAGENTA);
        colorMap.put(2, Color.YELLOW);
        colorMap.put(3, Color.GREEN);
        colorMap.put(4, Color.BLUE);
        colorMap.put(5, Color.WHITE);

        color = colorMap.get(colorIndex);

        ImageView square;

        // TODO Set color
        switch (squareIndex) {
            case 0:
                //square = (ImageView) findViewById(R.id.topLeft);
                break;
            case 1:
                //square = (ImageView) findViewById(R.id.topRight);
                break;
            case 2:
                //square = (ImageView) findViewById(R.id.bottomLeft);
                break;
            case 3:
                //square = (ImageView) findViewById(R.id.bottomRight);
                break;
            default:
                square = null;
        }

        //if (null == square){
        //      System.out.println("Error: square index invalid");
        // } else {
        //    square.setBackgroundColor(color);
        //}
    }
}