/**
 * The Pair Type class
 * 
 * @author (Vaughn Chan) 
 * @version (3.0: 01/24/2022)
 */
public class Pair<T1, T2>
{
    //declaring the first and second elements in the pair
    private T1 first;
    private T2 second;

    /**
     * Pair Constructor
     * 
     * For initializing object with empty variables
     */
    public Pair() {}

    /**
     * Pair Constructor
     *
     *For initializing object with member variables
     *
     * @param first the first element
     * @param second the second element
     */
    public Pair(T1 first, T2 second)
    {
        this.first = first;
        this.second = second;
    }

    /**
     * Method to set the first and second element
     *
     * @param first the first element
     * @param second the second element
     */
    public void setPair(T1 first, T2 second)
    {
        this.first = first;
        this.second = second;
    }

    /**
     * Method to get the first element
     *
     * @return the first element
     */
    public T1 getFirst()
    {
        return first;
    }

    /**
     * Method to get the second element
     *
     * @return the second element
     */
    public T2 getSecond()
    {
        return second;
    }

    /**
     * Method to print the string in the format "first element, second element"
     */
    public void printString()
    {
        System.out.println(first + ", " + second);
    }
}