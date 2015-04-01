package mobileapps.cse5236.cubr;
import java.util.*;
import java.io.*;
/**
 * Created by timryan on 3/31/15.
 */
public class ScoreManager {
    private ArrayList<Score> highScores;
    private static final String CUBR_HIGHSCORE_FILE = "cubr_highscores.dat";

    ObjectOutputStream out = null;
    ObjectInputStream in = null;

    public ScoreManager(){
        highScores = new ArrayList<Score>();
    }

    public ArrayList<Score> getHighScores(){
        loadHighScoreFile();
        sort();
        return highScores;
    }

    public void sort(){
        ScoreComparator comp = new ScoreComparator();
        Collections.sort(highScores,comp);
    }

    public void addHighScore(Score highScore){
        loadHighScoreFile();
        highScores.add(highScore);
        writeHighScoreFile();
    }

    public void removeHighScore(Score notHighScore){
        loadHighScoreFile();
        highScores.remove(notHighScore);
        writeHighScoreFile();
    }

    public void loadHighScoreFile(){
        try{
            in = new ObjectInputStream(new FileInputStream(CUBR_HIGHSCORE_FILE));
            highScores = (ArrayList<Score>) in.readObject();
        }catch (FileNotFoundException e){
            System.out.println("FILE NOT FOUND: " + e.getMessage());
        }catch (IOException e){
            System.out.println("IO EXCEPTION: " + e.getMessage());
        }catch (ClassNotFoundException e){
            System.out.println("CLASS NOT FOUND: " + e.getMessage());
        }
    }

    public void writeHighScoreFile(){
        try{
            out = new ObjectOutputStream(new FileOutputStream(CUBR_HIGHSCORE_FILE));
            out.writeObject(highScores);
        }catch (FileNotFoundException e){
            System.out.println("FILE NOT FOUND: " + e.getMessage());
        }catch (IOException e) {
            System.out.println("IO EXCEPTION: " + e.getMessage());
        }
    }
}
