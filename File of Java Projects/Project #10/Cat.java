public class Cat extends Animal   
{
   public Cat(String name) 
   {
      super(name);
   }

   public void speak()
   {
      speak(Cat -> 
      {
         System.out.print(getNameAndType());
      });
      System.out.println(" says 'Meow'");
   } 
}
