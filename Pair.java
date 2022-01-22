/**
 * Write a description of class Pair here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pair<T1, T2>
{
    private T1 first;
    private T2 second;

    // For initializing object with empty variables
    public Pair() {}

    // For initializing object with member variables
    public Pair(T1 first, T2 second)
    {
        this.first = first;
        this.second = second;
    }

    public void setPair(T1 first, T2 second)
    {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst()
    {
        return first;
    }

    public T2 getSecond()
    {
        return second;
    }

    public void printString()
    {
        System.out.println(first + ", " + second);
    }
}