import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Singleton class for reading and writing to a score file.
 * 
 * @author (Vaughn Chan) 
 * @version (3.0: 01/23/2022)
 */
public class ScoreFile
{
    // Instance object (the only object of this class allowed to exist)
    private static ScoreFile instance = new ScoreFile();
    
    // The directory path to the score file. "./" means the "current directory
    private static String scorePath = "./data/score.txt";
    
    // An array that holds the current scores. New scores added are added to the variable,
    // and then is used to update the file. This is similar to a "save" functionality.
    private ArrayList<Pair<String, Integer>> scoreData = new ArrayList<Pair<String, Integer>>();
    
    /**
     * Instance referencer (as a singleton, this replaces the constructor of this class)
     *
     * @return the scorefile
     */
    public static ScoreFile getInstance()
    {
        // When initialized, make sure score file actually exists
        createScoreFile();
        return instance;
    }
    
    /**
     * Method to get all scores from the file (used to display the scores)
     *
     * @return all scores from the file
     */
    public ArrayList<Pair<String,Integer>> getScoreData()
    {
        parseFileToData();
        return scoreData;
    }
    
    /**
     * Method to add a new score to the file
     *
     * @param newScore a new score
     */
    public void addScoreData(String name, int score)
    {
        int duplicateIndex = findDuplicate(name);
        
        // Check if the name registered is a duplicate
        if (findDuplicate(name) != -1)
        {
            // If it is a duplicate, then check if their score was higher than before
            if (score > scoreData.get(duplicateIndex).getSecond())
            {
                scoreData.set(duplicateIndex, new Pair<String,Integer>(name, score));   
            }
        }
        // Otherwise, add new entry to data
        else
        {
            scoreData.add(new Pair<String,Integer>(name, score));
        }
        sortScore();
        parseDataToFile();
    }
    
    /**
     * Helper method for checking for any duplicate names
     *
     * @param possibleDuplicate possible duplicate name
     * @return the index of the duplicate name
     */
    private int findDuplicate(String possibleDuplicate)
    {
        int count = 0;
        for (Pair<String, Integer> p : scoreData)
        {
            if (p.getFirst().equals(possibleDuplicate))
            {
                return count;
            }
            count++;
        }
        
        return -1;
    }
    
    /**
     * Helper method for checking if score file exists
     */
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
    
    /**
     * Method to sort the score in reverse order (largest to smallest)
     *
     */
    private void sortScore()
    {
        // Initialize sorted data
        int[] sortedScores = new int[scoreData.size()];
        for (int i = 0; i < scoreData.size(); i++)
        {
            sortedScores[i] = scoreData.get(i).getSecond();
        }
        
        // Sort the data and rematch names to scores
        sortedScores = Sort.reverseMergeSort(sortedScores);
        ArrayList<Pair<String,Integer>> oldData = new ArrayList(scoreData);
        scoreData.clear();
        
        // Replace current data with new data
        for (int score : sortedScores)
        {
            for (int i = 0; i < oldData.size(); i++)
            {
                if (oldData.get(i).getSecond() == score)
                {
                    scoreData.add(oldData.get(i));
                    oldData.remove(i);
                    i--;
                    break;
                }
            }
        }
    }
    
    /**
     * Method to convert data from file into the arraylist
     */
    public void parseFileToData()
    {
        scoreData.clear();
        try
        {
             BufferedReader br = new BufferedReader(new FileReader(scorePath));
             String rawData = "";
             String line;
             
             // Get the raw data
             while ((line = br.readLine()) != null) {
                 rawData += line;
             }

             // Split the data into array list via comma (CSV)
             String[] rawDataArr = rawData.split(",");

             // Put it into the arraylist
             for (int i = 0; i < rawDataArr.length - 1; i+=2)
             {
                 scoreData.add(new Pair<String, Integer>(rawDataArr[i], Integer.parseInt(rawDataArr[i+1])));
             }
             
             br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace(System.out);
        }
    }
    
    /**
     * Method to convert data from the arraylist into the file
     *
     */
    public void parseDataToFile()
    {
        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter(scorePath, false));
            
            for (Pair p : scoreData)
            {
                bw.write(p.getFirst() + "," + p.getSecond() + ",\n");
            }
            bw.close();
        }
        catch (IOException e) { };
    }
}