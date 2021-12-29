public class Dog extends Animal   

{
   public Dog(String name) 
   {
      super(name);
   }

   public void speak()
   {
      speak(Dog -> 
      {
         System.out.print(getNameAndType());
      });
      System.out.println(" says 'Woof! Woof!'");
   } 
} 
