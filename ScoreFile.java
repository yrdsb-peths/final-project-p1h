/**
 * Singleton class for reading and writing to a score file.
 * 
 * @author Vaughn Chan
 * @version 2022-01-19
 */
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ScoreFile
{
    private static ScoreFile instance = new ScoreFile();
    
    private String scorePath = "./data/score.txt";
    private ArrayList<Integer> scoreData = new ArrayList();
    
    public static ScoreFile getInstance()
    {
        return instance;
    }
    
    public ArrayList<Integer> getScoreData()
    {
        parseFileToData();
        return scoreData;
    }
    
    private void parseFileToData()
    {
        try
        {
             BufferedReader br = new BufferedReader(new FileReader(scorePath));
             String line;
             
             // logic for parsing file is here
             while ((line = br.readLine()) != null) {
                 scoreData.add(Integer.parseInt(line));
             }
        }
        catch (IOException e)
        {
            e.printStackTrace(System.out);
        }
    }
}
