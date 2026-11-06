public class Craps
{
    DiceRoll r;
    
    public Craps()
    {
        r = new DiceRoll ( );
    }

    // Returns 0 if lose, otherwise the amount won.
    public int play ( ) {
        int target=0;
        r.roll();
        if ((r.total())==2||(r.total())==3||(r.total()==12)){
            return 0;
        }
        else if (r.total()==7||r.total()==11){
            return 1;
        }
        target=r.total();
        r.roll();
        while (target!=r.total()){
            if (target==7){
                return 0;
            }
            r.roll();
            target=r.total();
        }
        return 1;

    }
    
    //simulate play to see your odds of winning
    public void tester(int howMany)
    {
        int totalWins=0;
    	for (int x=0;x<howMany;x++){
            totalWins=totalWins+play();
        }
        System.out.println("The odds of winning are " + totalWins*1.0/howMany*100 +" percent.");
    }

    public static void main(String[] args){
        Craps g = new Craps();
        g.tester(100);
    }
}

