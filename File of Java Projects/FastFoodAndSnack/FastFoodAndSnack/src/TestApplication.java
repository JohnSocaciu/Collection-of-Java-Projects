import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class TestApplication // Names the .java file 'TestApplication'

{ 
    private static FastFoodNew fastFoodVariables; 
    private static FastFoodNew hello; 
    static StringTokenizer stringToken; 
    private static String name; 
    private static String foodType;
    private static String cost;  
    private static String line; 
    private static TestApplication [] variables = new TestApplication[10];  
    
    static ArrayList <String> datVariables = new ArrayList <String>();
    static ArrayList <FastFoodNew> fastFoodObjects = new ArrayList <FastFoodNew>(); // creation of Arraylist 
    public static void main (String [] args)

    { 
        try
        { 
            FileReader fileReader = new FileReader("FastFoodData.txt");       // reading from FastFoodData.txt
            BufferedReader bufferedReader = new BufferedReader(fileReader); 
            readFromTxt(bufferedReader); 
        } 
        catch(IOException ioe)
        {
            System.out.println("Cannot Find 'FastFoodData.txt' File");
            System.exit(1);
        }

        try
        {
            FileWriter fileWrite = new FileWriter("FastFoodInfo.dat");       // contents of FastFoodData outputted to FastFoodInfo.dat
            BufferedWriter bufferedWrite = new BufferedWriter(fileWrite); 
            PrintWriter printWriter = new PrintWriter(bufferedWrite); 
            outputFromText(printWriter); 
            printWriter.close();
        }
        catch (IOException ieo)
        {
            System.out.println("Cannot Find 'FastFoodInfo.dat' File");
            System.exit(1); 
        }

        try
        {
            FileReader fileInput = new FileReader("FastFoodInfo.dat");    // for input (reading)
            BufferedReader bufferRead = new BufferedReader(fileInput);  
            readFromDat(bufferRead);
        }
        catch (IOException ieo)
        {
            System.out.println("Cannot Find 'FastFoodInfo.dat' File");
            System.exit(1); 
        } 
      
        try
        {
            FileWriter fileWrit = new FileWriter("FastFoodReport.txt");   // for output (FastFoodInfo being read and outputted to FastFoodReports)
            BufferedWriter bufferedReader = new BufferedWriter(fileWrit); 
            PrintWriter printOut = new PrintWriter(bufferedReader);
            outputFromDat(printOut);
            bufferedReader.close(); 
            printOut.close(); 
        }
        catch (IOException ieo)
        {
            System.out.println("Cannot Find 'FastFoodReport.txt' File");
            System.exit(1); 
        }
    }

        public static void outputFromDat (PrintWriter printOut) // prints the contents of the arraylist using a loop
        {
            for (int i = 2; i < datVariables.size(); ++i)      // outputs the contents of the arraylist in predetermined fashion 
            {
                printOut.print("Restaurant: " + name + "    ");
                printOut.print("Best Known For: " + foodType + "    ");
                printOut.print("Cost: " + cost);
                printOut.println();
            }
        }

        public static void readFromDat (BufferedReader bufferRead)
        {
  
            try
            {
                while ((line = bufferRead.readLine()) != null) // reads from the line and gets the data desired and adds to arraylist
                {
                    while (line != null)
                    {
                        datVariables.add(0,name); 
                        datVariables.add(0,foodType); 
                        datVariables.add(0,cost); 
                        line = bufferRead.readLine();
                    }
                }
            }
            catch (IOException ioe) 
            {
                System.out.println("unable to read from the fastfoodinfo.dat file because the file doesn't exist or can't be found");
                System.exit(1); 
            } 
        }

        public static void outputFromText(PrintWriter printWriter) // uses get methods to out the data initially read by using a loop and an arraylist
        {
            for (int i = 0; i < fastFoodObjects.size(); i++)
            {
                if (fastFoodObjects.get(i).equals(fastFoodVariables)); 
                {
                    printWriter.print(fastFoodVariables.getRName()+ " ");
                    printWriter.print(fastFoodVariables.getFType()+ " ");
                    printWriter.print(fastFoodVariables.getCost());
                    printWriter.println("");
                }
            }
        }

        public static void readFromTxt(BufferedReader bufferedReader)
        {
            try
            {   
                int i = 0; 

                while ((line = bufferedReader.readLine()) != null)  // "Read a line of input from the file"
                {
                    stringToken = new StringTokenizer(line,", "); 
                    if (stringToken.hasMoreElements())
                    { 
                        variables[i].name = stringToken.nextToken();       // gets all tokens inputted from everyline. 
                        variables[i].foodType = stringToken.nextToken();
                        variables[i].cost = stringToken.nextToken();
                        fastFoodVariables = new FastFoodNew(name, foodType, Double.parseDouble(cost));
                        fastFoodObjects.add(fastFoodVariables);  
                        i++; 
                    }
                }
            }
            catch (NumberFormatException numberFormat) // thrown when converting string to double and the string isn't in the proper format 
            {
                System.out.println("number format exception!"); 
            } 
            catch (ArrayIndexOutOfBoundsException arrayBounds) // because an array is being used - it's possible for the string line to not be tokenized
            {
                System.out.println("Array Index out of Bounds Exception - Line of input may or may not be tokenized");
            }
            catch (NoSuchElementException noProperElement) // it's possible for the user who initially inputs into the file being read to input the wrong kind of data
            {
                System.out.println("The Elements (variables) being search for and tokenized don't exist - input the proper string/double formation");
            }
            catch (IOException ioe) 
            {
                System.out.println("I/O Exception!");
                System.exit(1); 
            } 
   }
}