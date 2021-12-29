// Name: John Socaciu
// Class: CIS 1500 
// Professor: Asmi Mehta 
// Project Title: IceCreamOrder - Capstone project

package icecream;
     
import javafx.beans.value.ObservableValue; //imports used to create Hbox and gather user input
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner; // gathers user input 
import javafx.application.Application;
import javafx.scene.layout.HBox;

public class IceCream extends Application // Names the java file "IceCream" 

{

// variables are declared: 

String selectedType = "Chocolate"; // declares the variable "selectedType" equal to "chocolate" 
boolean cherryOption = false; // declares cherryOption and nutsOption as false 
boolean nutsOption = false;
double tax; // tax, order, and total are declared doubles becuase decimals will be included in their value
double order;
double total;

/**
 * The main() method is ignored in correctly deployed JavaFX application.
 * main() serves only as fallback in case the application can not be
 * launched through deployment artifacts, e.g., in IDEs with limited FX
 * support. NetBeans ignores main().
 *
 * @param args the command line arguments
 */

public static void main(String[] args) 
{
launch(args);
}

    /**
     *
     * @param initialStage
     */
    @Override
public void start (Stage initialStage) // allows the guii to start/run 

{

    HBox guii; // names the HBox "guii" 
    guii = new HBox(); // creates new HBox called 'guii'
    
    TitledPane titlepane1 = new TitledPane(); // creates new titledpane named titlepane1 
    GridPane firstGrid;// Names gridpane "firstGrid"   
    firstGrid = new GridPane(); // Creates a new gridpane in the process
    titlepane1.setText("Flavors"); // Adds name "Flavors" to titlepane1 (serves as a title to the below flavors) 
    ToggleGroup options; // names the togglegroup called options 
    options = new ToggleGroup(); // Creates new toggle group called group
    
    RadioButton chocolate; // Names radio button chocolate 
    chocolate = new RadioButton("Chocolate"); //creates new radiobutton called 'chocolate'  
    chocolate.setToggleGroup(options); // allows the user to only select one flavor/option in the togglegroup
    chocolate.setSelected(true); // selects the chocolate option automatically
    
    RadioButton vanilla; // Names the radiobutton 'vanilla' 
    vanilla = new RadioButton("Vanilla"); // creates a new radiobutton named vanilla 
    vanilla.setToggleGroup(options); // allows the user to only select one flavor/option in the togglegroup

    RadioButton strawberry; // Names the radiobutton
    strawberry = new RadioButton("Strawberry"); // creates a new radiobutton called strawberry
    strawberry.setToggleGroup(options); // allows the user to only select one flavor/option in the togglegroup
    
    firstGrid.add(chocolate, 0, 0); // Organizes the radiobuttons on the grid/togglegroup next to each other at the same height
    firstGrid.add(vanilla, 1, 0);
    firstGrid.add(strawberry, 2, 0);
    firstGrid.setHgap(15); // Sets the gap inbetween the radiobuttons to create seperation between the buttons 
    titlepane1.setContent(firstGrid); // sets content so that the titledpane for the 'flavor' shows on the guii 

    TitledPane titlePane2; // Names the titledpane 'titlepane2' 
    titlePane2 = new TitledPane(); // creates a new titledpane called 'titleoane2' 
    titlePane2.setText("Toppings"); // Names the titlepane 'Toppings' (serves as a title) 
    GridPane secondGrid; // names the gridpane 'secondGrid' 
    secondGrid = new GridPane(); // creates a Gridpane called 'secondGrid" 
    CheckBox nuts; // Names the checkbox 'nuts' 
    nuts = new CheckBox("Nuts"); // cretes a new checkbox called "nuts" 
    CheckBox cherry; // Names the checkbox 'cherry' 
    cherry = new CheckBox("Cherries"); // Creates a new checkbox called 'cherries' 
   
    secondGrid.add(nuts, 0, 0); // Organizes the radiobuttons on the grid/togglegroup next to each other at the same height
    secondGrid.add(cherry, 1, 0);
    secondGrid.setHgap(15); // Sets the gap inbetween the radiobuttons to create seperation between the buttons 
    titlePane2.setContent(secondGrid); // sets content so that the titledpane for the toppings shows on the guii 

    TitledPane titlePane3; // Names the Titledpane "titlepane3" 
    titlePane3 = new TitledPane(); // creates a new Titledpane called 'titlepane3' 
    titlePane3.setText("Order"); // names the titledpane 'Order' (title of the options) 
    GridPane thirdGrid; // Names the Gridpane 'thirdGrid' 
    thirdGrid = new GridPane(); // Creates a mew gridpane called 'thirdgrid' 
    Button cost; // Names a button 'cost' 
    cost = new Button("Calculate Cost"); // the new button 'cost' is entitled 'Calculate Cost' 
    Button save; // Names the button 'save' 
    save = new Button("Save"); // Creates a new button called 'save' 
    Button restore; // Names the button restore 
    restore = new Button("Restore"); // creates a new button called 'restore' 
   
    thirdGrid.add(cost, 0, 0); // Organizes the radiobuttons on the grid/togglegroup next to each other at the same height
    thirdGrid.add(save, 1, 0);
    thirdGrid.add(restore, 2, 0);
    thirdGrid.setHgap(15); // Sets the gap inbetween the radiobuttons to create seperation between the buttons 
    titlePane3.setContent(thirdGrid); // sets content so that the titledpane for the 'Order' shows on the guii 
        
options.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) -> 
{
    if (options.getSelectedToggle() != null) // this allows the icecream.txt file to update when a new flavor other than chocolate is selected
    {
        RadioButton selectedRadioButton =
                (RadioButton) options.getSelectedToggle();
        selectedType = selectedRadioButton.getText();
    }
});
  
cherry.setOnAction((ActionEvent event) -> // creates an action event that can be manipulated by the user if the user wants cheeries
{
    cherryOption = false; // sets the cherry option as false so that the user has to select it for it to be true
    if (cherry.isSelected()) // if the cherry option is selected it will be considered true... it will be checked 
    { 
        cherryOption = true;
    }
});

nuts.setOnAction((ActionEvent event) -> // creates an action event that can be manipulated by the user of the user wants nuts 
{
    nutsOption = false; // sets the nut option as false so that the user has to select it for it to be true
    if (nuts.isSelected()) // if the nut option is selected it will be considered true... it will be checked 
    {
        nutsOption = true;
    }
});
  
cost.setOnAction((ActionEvent event) -> { // creates an action event that can be manipulated by the user (cost of ice cream)
    
    order = 0; // attaches the variable 'order' to the value '0' 
    if (cherryOption) // adds $.50 if the user wants cherries on their ice cream 
    {
        order += 0.50;
    }
    if (nutsOption) // adds $.50 if the user wants nuts on their ice cream 
    {
        order += 0.50;
    }
    else // if the order doesn't contain nuts or cherries and if the order does contain nuts and cherries 
    {
        
    }
    order += 2.25; // cone + type of ice cream is automatically $2.25
    
    tax = order * 0.06; // multiplies the order by the tax (0.06) 
    
    total = tax + order ; // declares the total as tax + order 
    
    Alert orderWindow; // Names the Alert 'orderWindow' 
    orderWindow = new Alert(Alert.AlertType.INFORMATION); // creates a new Alert called "orderWindow" 
    orderWindow.setTitle("Your Order"); // titles the window of 'orderWindow' "Your Order" 
    orderWindow.setHeaderText(String.format("Total: $%.2f", total)); // puts the total at the top of the window 
    orderWindow.setContentText(String.format("Order:\t%.2f\n" + "Tax:" + "  " + "\t%.2f\n" + "Total:\t%.2f", order, tax, total));
    orderWindow.showAndWait(); // 'showandwait' allows the 'calculate cost' window to be opened 
    } // '\t' creates a space between the variables and the number associated with it 
    ); // '%.2f' creates decimals to the hundredth place... \n puts the corresponding variable on a new line within the 'Alert' 

save.setOnAction((ActionEvent event) -> // creates an action event that creates a save button so the user will can save their order 
{
    try (PrintWriter write = new PrintWriter("icecream.txt")) // creates an icecream.txt file 
    {
        write.append(selectedType + "\n"); // selects chocolate automatically 
        if (nutsOption) 
        {
            write.append("With_Nuts\n"); // Writes this if the user chooses nuts 
        }
        else
        {
            write.append("Without_Nuts\n"); // writes this if the user doesn't choose nuts 
        }
        if (cherryOption) 
        {
            write.append("With_Cherries\n"); // writes this if the user wants ice cream 
            
        } 
        else 
        {
            write.append("Without_Cherries\n"); // writes this if the user doesn't choose cherries 
        }
        
    } 
    
    catch (FileNotFoundException SavedOrder) // when no file/order is saved, the FileNotFoundException catches it and notifies the user... 
        
    {
    }
});

restore.setOnAction((ActionEvent event) -> { // Creates an action that restores the order last saved by the user 
    Scanner restoreFile = null;
    Alert orderRestore; // names the alert 'orderRestore' 
        orderRestore = new Alert(Alert.AlertType.INFORMATION); // creates a new alert declared as 'orderRestore' 
    orderRestore.setHeaderText("Last saved order"); // titles the window restored order window pane as "last saved order" 
    try {
        
        restoreFile = new Scanner(new FileReader("icecream.txt")); // reads the file icecream.txt (saved file) for the restorefile/alert 
      
        String nutsTopping = restoreFile.nextLine(); // declares 'nutsTopping,' 'iceFlavor,' and 'cherriesToppings' as strings 
        String iceFlavor = restoreFile.nextLine();
        String cherriesTopping = restoreFile.nextLine();
        
        switch (iceFlavor) // switch statement for the flavor selected by the user... declares some flavors as true depending on user input
        {
            case "Chocolate" -> chocolate.setSelected(true);
            case "Vanilla" -> vanilla.setSelected(true);
            case "Strawberry" -> strawberry.setSelected(true);
            default -> 
            {
            }
        }
        
        if (nutsTopping.equals("With_Nuts")) //selects nuts when the user presses the restore button and it was saved beforehand and vice versa 
        {
            nuts.setSelected(true);
        } 
        else 
        {
            nuts.setSelected(false);
        }
        if (cherriesTopping.equals("With_Cherries")) //selects cherries when the user presses the restore button and it was saved beforehand and vice versa 
        {
            cherry.setSelected(true);
        } 
        else 
        {
            cherry.setSelected(false);
        }
        
        orderRestore.setTitle("Last Saved Order"); // titles the alert "Last Saved Order" 
        orderRestore.setContentText(nutsTopping + "\n" + iceFlavor + "\n" + cherriesTopping); // lists the saved topings and flavors in the applicable order
        orderRestore.showAndWait(); // 'showandwait' allows the 'calculate cost' window to be opened
        
    } 
    catch (FileNotFoundException SavedOrder) // when no file/order is saved, the FileNotFoundException catches it and notifies the user... 
    {
        orderRestore.setTitle("Error Encountered"); // sets the title of the alert as "error encountered" 
        orderRestore.setContentText("icecream.txt (The system cannot find the file specified)"); // specifies the alart 
        orderRestore.showAndWait(); // 'showandwait' allows the 'calculate cost' window to be opened
    } 
   
});
  
guii.getChildren().add(titlepane1); //all three statements Create the titledpanes and the guii itself 
guii.getChildren().add(titlePane2);
guii.getChildren().add(titlePane3);

Scene windowScene; // creates a new scene called windowScene
windowScene = new Scene(guii); // creates a new scene in the guii declared as 'windowScene' 
initialStage.setTitle("John Socaciu - Ice Cream"); // Sets the title of application as "John Socaciu - Ice Cream" 
initialStage.setScene(windowScene); // sets the scene so that the titled panes show and the correct dimensions for the guii are used as well
initialStage.show(); // shows the guii/application itself 

}

}
