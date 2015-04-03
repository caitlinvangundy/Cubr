package mobileapps.cse5236.cubr;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by timryan on 3/31/15.
 */
public class Score implements Serializable {
    private long score;

    public long getScore() {
        return score;
    }

    public String getPrettyScore() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss.SSS");
        Date dt = new Date();
        dt.setTime(score);
        return timeFormat.format(dt);
    }

    public Score(long score) {
        this.score = score;
    }
}
