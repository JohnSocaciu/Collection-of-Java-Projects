public class RunnerThread extends Thread  
{
   
private int rand; 
private String name;         // a string representing the name of the runner 
private int chanceOfRest;    // an int value from 1 to 100 indicating the likelihood that on any given move the runner will rest instead of run
private int speed;           // an int value that indicates the runners speed�that is, how many meters the runner travels in each move 
private int position;        // an int value indicating the runner�s progress on the course 
    public static void main(String[] args) 
    {
      System.out.println("Get set...Go!"); 

      RunnerThread tortoise = new RunnerThread("Tortoise", 0, 10); // The main() method of the application’s
      tortoise.start();                                            // main class should create two runner threads and start them.

      RunnerThread hare = new RunnerThread("Hare", 90, 100);
      hare.start();
    }

    public RunnerThread(String characterName, int rest, int velocity) // constructor allowing for the existence of the tortoise and the hare characteristics
    {
      name = characterName;                                           // different movement speeds, names and chances of rest for each characters
      chanceOfRest = rest;
      speed = velocity;
    }
   
    public void run()
      { 
      while (position < 1000)  
         {
            rand = ((int) (Math.random() * 99)) + 1;
            if (rand > chanceOfRest) 
            {
               position += speed;
               System.out.println(this.name + ": " + position);
            }
            try
            {
               Thread.sleep(100); // The run() method should sleep for 100 milliseconds on each repetition of the loop.
            }
            catch(InterruptedException e) 
            {
               System.err.println(e);  
            }
         } // There might be a lengthy delay between when the hare finishes and the tortoise finishes

         System.out.println(this.name +": I finished!"); // When the loop ends, this method should display a message indicating that the runner has finished, include the runners identity and position in the message.     
      } 
}


