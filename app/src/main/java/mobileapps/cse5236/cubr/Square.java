package mobileapps.cse5236.cubr;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;

import java.util.HashMap;

/**
 * Created by Caitlin on 3/24/2015.
 */
public class Square {
    private HashMap<Integer, Integer> colorMap;
    private HashMap<Integer, String> imageMap;
    private int squareId;
    public int color;
    public String image;
    private boolean isColorBlindOn;
    public ImageView imageView;

    public Square(int colorIndex, int squareIndex) {
        squareId = squareIndex;

        colorMap = new HashMap<Integer, Integer>();
        colorMap.put(0, Color.RED);
        colorMap.put(1, Color.MAGENTA);
        colorMap.put(2, Color.YELLOW);
        colorMap.put(3, Color.GREEN);
        colorMap.put(4, Color.BLUE);
        colorMap.put(5, Color.WHITE);

        imageMap = new HashMap<Integer, String>();
        imageMap.put(0, "circle");
        imageMap.put(1, "heart");
        imageMap.put(2, "square");
        imageMap.put(3, "star");
        imageMap.put(4, "triangle");
        imageMap.put(5, "x");

        color = colorMap.get(colorIndex);
        image = imageMap.get(colorIndex);
    }
}