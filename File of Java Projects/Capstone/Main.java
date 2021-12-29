// John Socaciu 
// CIS 2353 
// Fall 2021
// Prof. John P. Baugh 

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main 
{
       public static void main(String[] args) 
    {
        TriageSimulator simulation = new TriageSimulator(); // instance of TriageSimulator

        try {
            FileReader reader = new FileReader("data.txt");  //reading from file data.txt 
            Scanner scan = new Scanner(reader);

            while (scan.hasNext()) // reading everyline 
            {
                simulation.add(scan.nextLine()); //TriageSimulator instance using add method to add every line 
            }
            scan.close(); // closing scanner to avoid resource leak 
        } 
        catch (FileNotFoundException fileNotFound) // exception to output 'file wasn't found' if not found 
        {
            System.out.println("File Wasn't Foind!");
        }

        System.out.println("The Next person who will be seen by the doctor: " + simulation.remove()); // using instance of triage and remove method
        System.out.println("The Next person who will be seen by the doctor: " + simulation.remove()); // outputting in console 
        System.out.println("The Next person who will be seen by the doctor: " + simulation.remove());
        System.out.println("The Next person who will be seen by the doctor: " + simulation.remove());
        System.out.println("The Next person who will be seen by the doctor: " + simulation.remove());
        System.out.println("The Next person who will be seen by the doctor: " + simulation.remove());
        System.out.println("The Next person who will be seen by the doctor: " + simulation.remove());
        System.out.println("The Next person who will be seen by the doctor: " + simulation.remove());
    }
}
