public class FastFoodNew  // Names the class and the file name "FastFoodAndSnack" 
{

        private String restaurantName; // access modifying --> strings made private --> only accessible within their own declared class  
        private String foodType;
        private double cost; 
    
        public FastFoodNew()	//	Default constructor assigning null values to the data members [instance	variables] 
        { 
            restaurantName	= ""; 
            foodType = ""; 
            cost = 0.0; 
        } 
        
        public FastFoodNew(String Rs, String Ft, double Cst)	//	non-default	constructor	assigning a	parameter value
        {																	//	to	each data member [instance	variable] 
            restaurantName = Rs;
            foodType = Ft;	// assigning string values to other string values
            cost = Cst; 
        } 
        
        public void setRName(String Rs)  // creating setters or mutator methods for user application
        {                            // to alter values in private data members (instance variables)
            restaurantName = Rs; 
        } 
        
        public void setFType(String Ft) 
        { 
            foodType = Ft;
        }
        
        public void setCost(double Cst) 
        {
            cost = Cst; 
        } 
        
        public String getRName() // creating get methods that allow user application to see or 
        {                     // extract copies of the values stored in the data members
            return restaurantName; 
        } 
        
        public String getFType() 
        { 
            return foodType; 
        } 

        public double getCost() 
        {
            return cost; 
        } 
        
        public void displaydata() // method that prints/displays a template as well data that
        {                         // that can change based on user input whenever the program runs 
            System.out.println("*********************"); 
            System.out.println("Name: " + restaurantName); 
            System.out.println("Food Type: " + foodType); 
            System.out.println("Cost: " + cost); 
            System.out.println("*********************"); 
        }
} 
   


