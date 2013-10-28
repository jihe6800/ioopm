public class FiveDices {
    Die firstDie =  new Die();
    Die secondDie = new Die();
    Die thirdDie =  new Die();
    Die fourthDie = new Die();
    Die fifthDie =  new Die();
    private int rolls = 0;
    

    public void roll() {
	firstDie.roll();
	secondDie.roll();
	thirdDie.roll();
	fourthDie.roll();
	fifthDie.roll();
	rolls += 1;
    }

    public void saveFirst() {
	firstDie.setSave();
    }
    
    public void saveSecond() {
	secondDie.setSave();
    }
    
    public void saveThird() {
	thirdDie.setSave();
    }
    
    public void saveFourth() {
	fourthDie.setSave();
    }
    
    public void saveFifth() {
	fifthDie.setSave();
    }

    public String toString() {
	return "First die rolled " + firstDie.getValue() +
	    "\nSecond die rolled " + secondDie.getValue() + 
	    "\nThird die rolled " + thirdDie.getValue() + 
	    "\nFourth die rolled " + fourthDie.getValue() + 
	    "\nFifth die rolled " + fifthDie.getValue() +
	    "\n__________________";
    }
}