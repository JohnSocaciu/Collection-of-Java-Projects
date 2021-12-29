//  John Socaciu
//  CIS 2353 
//  Fall 2021 
//  Project 2 

class ScoreNode    // "The ScoreNode class represents an individual score. This requires a name of type String, and a score of type 
{                  //  integer, and obviously a reference to the next node in the chain."
    String name; 
    int score; 
    ScoreNode nextNode;

    public ScoreNode(String name, int score) //non-default constructor 
    {
        this.name = name; 
        this.score = score; 
        nextNode = null;
    }
}
