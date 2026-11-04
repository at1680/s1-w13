import java.util.Random;

public class StPeters
{
    private Random randGen = new Random ( );
    private double entryFee;
    private int pot = 1;
   
    public StPeters(double fee){
        this.entryFee = fee;    
    }
    
    public void optimizeEntryFee(){
        int total=0;
        for(int x = 0; x<=1000; x++){
            total=total+runGame();
        }
        System.out.println("The optimized entry fee is " + total*1.0/1000 + " dollars");
    }
    
    public void tester(int howMany){
        int counter = 0;
        int countBreakEvenOrWin=0;
        while(counter < howMany)
        {
           pot = 1;
           if(runGame() <= this.entryFee)
                countBreakEvenOrWin++;
           counter++;
        }
        System.out.println("Entry Fee: " + this.entryFee + " : " + countBreakEvenOrWin + " broke even or won out of " + howMany + " tries. Chance of winning: " + countBreakEvenOrWin * 1.0 / howMany); 
    }
    
    //returns the amount of money you win in the game
    private int runGame(){
        int x = flip();
           pot=1;
           while (x!=1){
            pot=pot+2;
            x = this.flip();
           }

           return pot;
    }
    
    //code to return a 0 or 1 simulating a flip
    private int flip(){
        return randGen.nextInt(2);
    } 
    
    public static void main(String[] args){
      StPeters g = new StPeters(1.0);
      g.optimizeEntryFee();
   }
}
