public class Turtle extends Animal   

{
   public Turtle(String name) 
   {
      super(name);
   }

   public void speak()
   {
      speak(Turtle -> 
      {
         System.out.print(getNameAndType());
      });
      System.out.println(" waves! (turtles don't have vocal cords)");
   } 
   
} 
