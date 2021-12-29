//  John Socaciu
//  CIS 2353 
//  Fall 2021 
//  Project 2 

class ScoresList 
{
    ScoreNode head;       //instances of the node class 
    ScoreNode addInfo; 
    ScoreNode priorNode; 
    ScoreNode presentNode; 
    ScoreNode newNode; 
    ScoreNode printNode; 
    ScoreNode headOfList; 
    ScoreNode deletionChoice; 
    
    public ScoresList() // "Sets the ScoreList’s linked head node (front) to null"
    {
        head = null; 
    }

    public ScoresList(ScoresList otherList) //gets a copy of the otherlist(Scores.txt)
    {
        headOfList = otherList.head;
        addInfo = headOfList.nextNode;

        while (addInfo != null) // as long as addInfo (instance of node class) contains scores and names 
        {
            add(addInfo.name, addInfo.score); // adds scores and names to list 
            addInfo = addInfo.nextNode; 
        }
    }

    public void add(String name, int score) // passes name and score (parameters)
    {
       newNode = new ScoreNode(name, score); // instance of ScoreNode which allows the addition of a score and name 
       presentNode = head;                   // which is possible because of the non-default (parameterized) constructor in ScoreNode
       priorNode = null;

       while ((presentNode != null) && (presentNode.score >= score)) // while loop that organizes data in descending order (highest to lowest score)
       {
           priorNode = presentNode;
           presentNode = presentNode.nextNode;
       }

       if (priorNode != null)
       {
           newNode.nextNode = presentNode;
           priorNode.nextNode = newNode;
       }
       
       else if (priorNode == null)
       {
           newNode.nextNode = head;
           head = newNode;
       }
    } 

    public void remove(String name)
    {  
        presentNode = head;  
        priorNode = null; 

        if (presentNode.name.equalsIgnoreCase(name)) // deletes head of list 
        {
            head = presentNode.nextNode;
        }
       
        if ((presentNode.nextNode == null) && (presentNode.name.equalsIgnoreCase(name)))
        {
            priorNode = presentNode; 
            presentNode = priorNode.nextNode; 
        }

        while (presentNode.nextNode != null) // deletes mid nodes  
        {
            if (presentNode.nextNode.name.equalsIgnoreCase(name))
            {
                presentNode.nextNode = presentNode.nextNode.nextNode; 
            }
        presentNode = presentNode.nextNode; 
        } 
    }
    
    public void print()
    {
       for(printNode = head; printNode != null; printNode = printNode.nextNode) //prints Names and Scores in score.txt file
       {                                                                        
           System.out.println(printNode.name + " " + printNode.score);          //print() is also used to print list after addition 
       }                                                                        //and removal of names and scores
    }
    
}
