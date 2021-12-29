// John Socaciu
// CIS 2353 
// Fall 2021
// Prof. John P. Baugh 

public class TriageSimulator 
{
    private Queue queuePriorityFirst; // new Queue objects 
    private Queue queuePrioritySecond; 
    private Queue queuePriorityThird;
    private String [] line; // string array
    private String name; 

    public TriageSimulator()
    {
        this.queuePriorityFirst = new Queue();
        this.queuePrioritySecond = new Queue();
        this.queuePriorityThird = new Queue();
    }

    public void add(String lineFromFile) 
    {
        line = lineFromFile.split(" "); //deliminates a single space
        int priority = getPriorityNumber(line[2]); // priority number at index 2 
        name = line[0] + " " + line[1];   //index 0 contains names, index 1 contains last names 

        if (priority == 1)
            queuePriorityFirst.enqueue(name); //enqueues names from line array based on priority #
        else if (priority == 2)
            queuePrioritySecond.enqueue(name);
        else
            queuePriorityThird.enqueue(name);
    }

    public String remove()
    {
        if (!queuePriorityFirst.isEmpty()) // if there's no more priority patients in first, return dequeue, meaning ending the queue
        {
            return queuePriorityFirst.dequeue(); 
        }
        else if (!queuePrioritySecond.isEmpty())  // if there's no more priority patients in second or third, return dequeue, meaning ending the queue
            return queuePrioritySecond.dequeue();
            return queuePriorityThird.dequeue();
    }

    public boolean isEmpty()
    {
        return queuePriorityFirst.isEmpty() && queuePrioritySecond.isEmpty() && queuePriorityThird.isEmpty();
    }

    public int getPriorityNumber(String data)
    {
        if (data.equals("AL") || data.equals("HA") || data.equals("ST"))
        {
            return 1; // returns priority 1 if patients have these injuries 
        }
        else if (data.equals("BL") || data.equals("SF") || data.equals("IW") || data.equals("KS") || data.equals("OT"))
            return 2; // return 2 and 3 priority if patients have these injuries 
            return 3; 
    }
}
