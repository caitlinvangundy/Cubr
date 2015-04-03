package mobileapps.cse5236.cubr;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.*;
import java.io.*;
/**
 * Created by timryan on 3/31/15.
 */
public class ScoreManager {
    private ArrayList<Score> highScores;
    private int maxScores = 10;
    Context context = null;
    SharedPreferences prefs = null;
    SharedPreferences.Editor editor = null;

    public ScoreManager(Context context) {
        this.context = context;
        prefs = context.getSharedPreferences("cubr_highscores", Context.MODE_PRIVATE);
        editor = prefs.edit();
        editor.putStringSet("highTimes", Collections.<String>emptySet());
        editor.commit();
        highScores = new ArrayList<Score>();
    }

    public Score getCurrentHighScore() {
        getHighScores();
        if (!highScores.isEmpty()) {
            sort();
            return highScores.get(0);
        }
        return null;
    }

    public ArrayList<Score> getHighScores() {
        loadHighScoreFile();
        sort();
        return highScores;
    }

    private void sort() {
        ScoreComparator comp = new ScoreComparator();
        Collections.sort(highScores, comp);
    }

    public void addHighScore(Score highScore) {
        if (highScores.size() >= maxScores) {
            highScores.remove(maxScores - 1);
        }
        System.out.println("Adding Score: "+highScore.getScore());
        highScores.add(highScore);
        System.out.println("highscores array: " + highScores.toString());
        writeHighScoreFile();
    }

    private void loadHighScoreFile() {
        ArrayList<String> times = new ArrayList<String>();

        Set<String> setTimes = prefs.getStringSet("highTimes", null);
        System.out.println("SETTIMES: "+setTimes);
        times.addAll(setTimes);
        int arrayLength = times.size();
        for(int i=0; i<arrayLength; i++){
            Score score = new Score(Long.valueOf(times.get(i)));
            System.out.println("time"+i+": "+score.getScore());
            highScores.add(score);
            System.out.println("loadhighscorefilesize: "+highScores.size());
        }
    }

    private void writeHighScoreFile() {
        highScores = getHighScores();
        ArrayList<String> times = new ArrayList<String>();

        int arrayLength = highScores.size();
        System.out.println("writer highscores size: " + arrayLength);
        for(int i=0; i<arrayLength; i++){
            times.add(String.valueOf(highScores.get(i).getScore()));
            System.out.println("WRITERARRAYTIMES: "+times.get(i).toString());
        }
        Set<String> setTimes = new HashSet<String>();
        setTimes.addAll(times);
        System.out.println("WRITERSETTIMES: "+setTimes);
        editor.putStringSet("highTimes", setTimes);
        editor.commit();
    }
}
