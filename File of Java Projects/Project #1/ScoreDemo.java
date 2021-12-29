//  John Socaciu
//  CIS 2353 
//  Fall 2021 
//  Project 2 

import java.util.Scanner;
import java.io.*;
import java.nio.file.*;

public class ScoreDemo 
{ 
    public static void main (String [] args) throws IOException
    {

    String addNameAndScore; 
    String [] newScore; 
    String removeName; 

    Path productsPath = Paths.get("scores.txt"); // path for scores.txt file 
    File productsFile = productsPath.toFile();

    Scanner scoreFile = new Scanner(productsFile); 

    ScoresList linkedNode = new ScoresList(); 

    while(scoreFile.hasNext()) //creating copy of scores.txt
        {
            linkedNode.add(scoreFile.next(),scoreFile.nextInt()); // adds names and files to the instantiated object (linkedNode)
        } 

    scoreFile.close(); // closes scanner 

    Scanner userInput = new Scanner(System.in); 

    while (true) // loops until break(); 
    {
    System.out.println("Would you like to add another (1), remove (2), or quit the program (3)?"); // asks for user input
    int userChoice = Integer.parseInt(userInput.nextLine());

        if (userChoice == 1)
        { 
            System.out.println("Write the name followed by score"); // gathers user input 
            addNameAndScore = userInput.nextLine(); 
            newScore = addNameAndScore.split(" "); // puts the new name and score into an array and splits them with a space
            linkedNode.add(newScore[0],Integer.parseInt(newScore[1])); // adds new name and score
            System.out.println("The new scores are:");
            linkedNode.print(); // prints using the method "print"
        }

        else if (userChoice == 2)
        {
            System.out.println("Write the name of the person you’d like to remove"); 
            removeName = userInput.nextLine(); // gathers user input 
            linkedNode.remove(removeName); // removes score and name input from list 
            System.out.println("The new scores are:");
            linkedNode.print(); // prints the new list 
        }

        else if (userChoice == 3)
        {
            System.out.println("Thanks for using the program! Goodbye!");
            break; // breaks the while (true) loop 
        } 
    }

    userInput.close(); // closes scanner 

    }
}
