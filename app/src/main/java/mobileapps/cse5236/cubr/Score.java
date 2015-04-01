package mobileapps.cse5236.cubr;
import java.io.Serializable;
/**
 * Created by timryan on 3/31/15.
 */
public class Score implements Serializable{
    private String name;
    private int score;

    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }

    public Score(String name, int score){
        this.name = name;
        this.score = score;
    }
}
