package mobileapps.cse5236.cubr;
import java.util.Comparator;
/**
 * Created by timryan on 3/31/15.
 */
public class ScoreComparator implements Comparator<Score>{
    public int compare (Score a, Score b){
        int scoreA = a.getScore();
        int scoreB = b.getScore();

        if(scoreA > scoreB)
        {
            return 1;
        }
        else if(scoreA < scoreB)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
}
