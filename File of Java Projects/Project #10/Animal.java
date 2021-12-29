import java.util.function.Consumer;

public abstract class Animal 
{
private String name;
   
      public Animal(String name) 
      {
         this.name = name; 
      }
      
      public String getName()
      {
         return name;  
      }
      
      public void setName(String name)
      {
         this.name = name; 
      } 
      
      public String getNameAndType() // this method should return the animal's name concatenated with 'the' and the type of the class (example: �Percy the Cat�
      {
          String type = "";
          if (this instanceof Cat)
              type = "Cat";
          else if (this instanceof Dog)
              type = "Dog";
          else type = "Turtle";
         return name + " the " + type; //class;
      }
      
      public abstract void speak();
      
      protected void speak(Consumer <Animal> consumer) //this method will call consumer.accept(this);// for the current anima
      {
         consumer.accept(this);
      }
}
