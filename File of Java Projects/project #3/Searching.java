// John Socaciu
// CIS 2353 
// Fall 2021 
// Prof. John P. Baugh

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Searching {

    private static Map <String, String [] > imageAndKeywords = new HashMap<String, String[]>(); 
    private static List <String> resultList = new ArrayList <String>(); 
    private static List <String> fileContents = new ArrayList <String>(); // create new list to store values from .txt file
    private static String [] stringSearch = new String [3]; 
    private static String [] arrayKey = new String [3];
    private static String [] wordsArray = new String [20]; 
    private static String [] keyWords = new String [20]; 
    private static String userSearch;  
    private static String line; 
    private static int increment = 0;
    private static Scanner userInput;
   public static void main(String[] args)  
   {
        userInput = new Scanner(System.in);                       // create scanner to accept input from user

        fileContents = readFromFile();                            // reads lines from inputFile.txt and adds to list 
        imageAndKeywords = storingData(fileContents);             // hashmap that collects the file contents read, line by line, by the method groupList

        System.out.println("What would you like to search for?"); // collecting user input 
        userSearch = userInput.nextLine();                        // storing user input in string searchList
        userInput.close();                                        // closes scanner 

        resultList = searchForImage(userSearch, imageAndKeywords);   // matches user input (string or keywords) to images and inputs images into resultList ('List')

        System.out.println();
        for (String resultingImage : resultList) 
        {
            System.out.println(resultingImage);                   // outputs the resulting image(s) based on keywords inputted 
        }
    }

        public static List <String> readFromFile()     // reads lines from inputFile.txt
        { 
            try 
            {
            FileReader fileReader = new FileReader("inputFile.txt"); 
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            line = bufferedReader.readLine();
                while (line != null)                  // reads everyline from input or "reader" file 
                {
                    fileContents.add(line);
                    line = bufferedReader.readLine();
                }
            bufferedReader.close();                           // closes buffered reader - (avoiding "resource leak")
            } 
            catch (IOException IO) 
            {
                System.out.println("File Cannot Be Found!");
            }
        return fileContents;
        }

         public static Map <String, String []> storingData (List <String> fileContents)  // method to store data in hashmap to "map keys to values"
         {
                for (String stringInput : fileContents) 
                {
                    wordsArray = stringInput.split(" ");
                    for (int i = 0; i < wordsArray.length; i++) 
                    {
                        keyWords[i] = wordsArray[i];
                        imageAndKeywords.put(keyWords[0], wordsArray);
                    }
                }
                return imageAndKeywords;
         }
        
        private static List<String> searchForImage(String searchList, Map<String, String[]> imageAndKeywords) 
        {

            if (userSearch.toLowerCase().contains("or")) // if userSearch contains the logic connective 'or'  
            {
                stringSearch = userSearch.toLowerCase().split(" or "); // removes 'or' and two spaces from userinput and inserts keywords entered by user into array
                if (stringSearch.length > 2) 
                {
                    System.out.println("only one logic connective can be applied per search");
                    System.exit(1);
                }

                for (String userKeyWord : stringSearch) 
                {
                    for (String keyWord : imageAndKeywords.keySet()) 
                    {
                        arrayKey = imageAndKeywords.get(keyWord);

                        for (String images : arrayKey) 
                        {
                            if (userKeyWord.equals(images)) 
                            {
                                resultList.add(keyWord); // adding to Arraylist list
                            }
                        }
                    }
                }
            } 
            
            else if (userSearch.toLowerCase().contains("and")) // if the keywords are seperated by the word 'and' in uppercase or lowercase methods
            {
                stringSearch = userSearch.toLowerCase().split(" and "); // removes 'and' and two spaces from userinput and inserts keywords entered by user into array
                
                if (stringSearch.length > 2) // only two keywords can be used 
                {
                    System.out.println("only one logic connective can be applied per search"); // prints and exits application if two 'AND's are used
                    System.exit(1);
                }
                for (String searchingForString : imageAndKeywords.keySet()) 
                {
                    arrayKey = imageAndKeywords.get(searchingForString);

                    for (String search : arrayKey) 
                    {
                        if (stringSearch[0].equals(search)) 
                        {
                            increment++;
                        }
                        if (stringSearch[1].equals(search)) 
                        {
                            increment++;
                        }
                        if (increment == 2) 
                        {
                            resultList.add(searchingForString); // adding to Arraylist list 
                        }
                    }
                }
            }

            else // if there's no logical connective and only one keyword 
            {
                for (String keyWord : imageAndKeywords.keySet()) 
                {
                    arrayKey = imageAndKeywords.get(keyWord);

                    for (String searching : arrayKey) 
                    {
                        if (userSearch.toLowerCase().equals(searching.toLowerCase())) 
                        {
                            resultList.add(keyWord); // adding to Arraylist list
                        }
                    }
                }
            }
            return resultList;
        }
}