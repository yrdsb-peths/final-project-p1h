/**
 * Singleton class for reading and writing to a score file.
 * 
 * @author Vaughn Chan
 * @version 2022-01-19
 */
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ScoreFile
{
    private static ScoreFile instance = new ScoreFile();
    
    private static String scorePath = "./data/score.txt";
    private ArrayList<Integer> scoreData = new ArrayList<Integer>();
    
    public static ScoreFile getInstance()
    {
        // When initialized, make sure score file actually exists
        createScoreFile();
        return instance;
    }
    
    public ArrayList<Integer> getScoreData()
    {
        parseFileToData();
        return scoreData;
    }
    
    public void addScoreData(int newScore)
    {
        scoreData.add(newScore);
        sortScore();
        parseDataToFile();
    }
    
    private static void createScoreFile()
    {
        try
        {
            File scoreFile = new File(scorePath);
            if (!scoreFile.exists()){
                scoreFile.createNewFile();
            }
        }
        catch (IOException e)
        {
            System.out.println("Something went wrong...");
            e.printStackTrace(System.out);
        }
    }
    
    private void sortScore()
    {
        // Initialize sorted data
        int[] sortedData = new int[scoreData.size()];
        for (int i = 0; i < scoreData.size(); i++)
        {
            sortedData[i] = scoreData.get(i);
        }
        
        // Sort the data and wipe out old data
        sortedData = Sort.reverseMergeSort(sortedData);
        scoreData.clear();
        
        // Replace current data with new data
        for (int score: sortedData)
        {
            scoreData.add(score);
        }
    }
    
    private void parseFileToData()
    {
        scoreData.clear();
        try
        {
             BufferedReader br = new BufferedReader(new FileReader(scorePath));
             String line;
             
             // logic for parsing file is here
             while ((line = br.readLine()) != null) {
                 scoreData.add(Integer.parseInt(line));
             }
             
             br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace(System.out);
        }
    }
    
    private void parseDataToFile()
    {
        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter(scorePath, false));
            
            for (int score : scoreData)
            {
                bw.write(score + "\n");
            }
            bw.close();
        }
        catch (IOException e) { };
    }
}
