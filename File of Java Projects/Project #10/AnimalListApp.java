import java.util.ArrayList;
import java.util.Scanner;

public class AnimalListApp 
{
    public static void main(String[] args) 
    {
        int type;
        String animalName;
        String choice = "y";

        ArrayList<Animal> animalChoice = new ArrayList<>();

        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the Animal List");

        while (choice.equalsIgnoreCase("y")) // continues only if choice of whether or not to continue is 'y'
        {
            System.out.println("Type of animal: ");
            System.out.println("1 - Dog");
            System.out.println("2 - Cat");
            System.out.println("3 - Turtle");

            System.out.println("Choose type: ");
            type = Integer.parseInt(scan.nextLine());

            System.out.println("Enter animal name: ");
            animalName = scan.nextLine();

            System.out.println("Continue? y/n: ");
            choice = scan.nextLine();

            if (type == 1) 
            {
                Dog dogObject = new Dog(animalName);
                dogObject.setName(animalName);
                animalChoice.add(dogObject);

            } else if (type == 2) 
            {
                Cat catObject = new Cat(animalName);
                catObject.setName(animalName);
                animalChoice.add(catObject);
            } else if (type == 3) 
            {
                Turtle turtleObject = new Turtle(animalName);
                turtleObject.setName(animalName);
                animalChoice.add(turtleObject);
            }

            if (choice.equalsIgnoreCase("n"))
             {
                System.out.println("And now let's hear the animals speak");
                System.out.println("-----------------------------------");

                for (Animal animal : animalChoice) 
                {
                    animal.speak();
                }
                break;
            }
        }
        scan.close();
    }

} 
