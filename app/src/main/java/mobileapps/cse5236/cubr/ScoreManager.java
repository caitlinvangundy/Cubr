package mobileapps.cse5236.cubr;

import android.content.Context;

import java.util.*;
import java.io.*;

/**
 * Created by timryan on 3/31/15.
 */
public class ScoreManager {
    private ArrayList<Score> highScores;
    private int maxScores = 10;
    private String cubrHighScoreFile;
    private ObjectOutputStream out = null;
    private ObjectInputStream in = null;

    public ScoreManager(String filePath) {
        highScores = new ArrayList<Score>();
        cubrHighScoreFile = filePath + "cubr_highscores.dat";
    }

    public Score getCurrentHighScore() {
        getHighScores();
        if (!highScores.isEmpty()) {
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
        highScores = getHighScores();
        if (highScores.size() >= maxScores) {
            highScores.remove(maxScores - 1);
        }
        highScores.add(highScore);
        writeHighScoreFile();
    }

    private void loadHighScoreFile() {
        try {
            in = new ObjectInputStream(new FileInputStream(cubrHighScoreFile));
            highScores = (ArrayList<Score>) in.readObject();
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO EXCEPTION: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("CLASS NOT FOUND: " + e.getMessage());
        }
    }

    private void writeHighScoreFile() {
        try {
            out = new ObjectOutputStream(new FileOutputStream(cubrHighScoreFile));
            out.writeObject(highScores);
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO EXCEPTION: " + e.getMessage());
        }
    }
}
