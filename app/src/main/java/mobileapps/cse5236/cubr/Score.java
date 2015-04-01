package mobileapps.cse5236.cubr;
import java.io.Serializable;
/**
 * Created by timryan on 3/31/15.
 */
public class Score implements Serializable{
    private String name;
    private long score;

    public String getName(){
        return name;
    }

    public long getScore(){
        return score;
    }

    public Score(String name, long score){
        this.name = name;
        this.score = score;
    }
}
