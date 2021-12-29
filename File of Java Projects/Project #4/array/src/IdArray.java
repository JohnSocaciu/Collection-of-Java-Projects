import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;
import java.util.StringTokenizer; 

public class IdArray extends JFrame 
{
    private JTextField arrayInput; // declaring variables 
    private String arrayText; 
    private String token; 
    private Container arrayContainer = getContentPane(); 
    private JButton clearButton; 
    private int i; 
    int [] nums = new int [10]; // creating a new array called nums that has/allows 10 elements/cells 
    
    public static void main(String[] args) // responsible for displaying the window in which the user inputs data
    {  
        IdArray arrayApplication = new IdArray(); 
        arrayApplication.setVisible(true); 
        arrayApplication.setSize(400,300); // sets size of application window 
    }

    public IdArray() // creates textfield and button 
    {
        arrayContainer.setLayout(new FlowLayout());             
        arrayInput = new JTextField(30);
        clearButton = new JButton("Clear The Frame (textfield)"); 
        
        arrayContainer.add(arrayInput); //textfield first to appear in window 
        arrayContainer.add(clearButton); //button to appear second 
 
        Handler actionHandler = new Handler(); 
        arrayInput.addActionListener(actionHandler); 
        clearButton.addActionListener(actionHandler); 
    }

    public void display()
    {
        System.out.println("The contents of the array are ");
        for (int x = 0; x < nums.length; x++)
            {
                System.out.print(" " + nums[x]); // adds space between integers displayed in array
            }
    }
    
    public void evaluateInput() throws InvalidDecimalInputException
    {
        if (token.indexOf(".",0) != -1)
            throw new InvalidDecimalInputException("no decimals allowed"); // doesn't display decimals if inputted and displays an exception message to the user instead in the textfield
    
        nums[i] = Integer.parseInt(token); //converts each token (string) into an integer throughout the array
        i++; // increment 
    } 

    public class Handler implements ActionListener    
    {
        public void actionPerformed(ActionEvent e)
        {
        arrayText = arrayInput.getText(); // gets element array input from user 
        StringTokenizer whatsUp = new StringTokenizer(arrayText,", "); // excludes commas and "excessive" spaces by user beyond one space in length
        arrayInput.setText(""); // clears the frame after each user input, except after an exception 
            i = 0;
            while (whatsUp.hasMoreTokens())
            {
                try
                { 
                    token = whatsUp.nextToken(); // gathers integers inputted without commas or excessive spacing by userinput
                    evaluateInput();
                } 
                catch (ArrayIndexOutOfBoundsException arrayBounds) // catches and tells user in ArrayInput (in the app window) that to many integers were inputted based on array index size
                {
                    arrayInput.setText(arrayBounds.toString()); 
                }
                catch (InvalidDecimalInputException invalidDecimal)
                {
                    arrayInput.setText(invalidDecimal.toString());
                }
                catch (NumberFormatException numFormat)
                {
                    arrayInput.setText(numFormat.toString()); 
                } 
            }
        display(); // call to display method in order to print integers in array after any exceptions are caught in while loop 
        }
    }

    private class InvalidDecimalInputException extends Exception // creation of new exception class InvalidDecimalInputException 
    {
        public InvalidDecimalInputException(String s)
        {
            super(s);
        }
    }

}

