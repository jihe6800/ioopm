public class PairOfDice {
    Die firstDie =  new Die();
    Die secondDie = new Die();

    public PairOfDice() {
	this(6);
    }
    
    public PairOfDice(int numberOfSides){
	firstDie.setSides(numberOfSides);
	secondDie.setSides(numberOfSides);
    }

    public void roll() {
	firstDie.roll();
	secondDie.roll();
    }

    public int getFirstDieValue() {
	return firstDie.getValue();
    }

    public int getSecondDieValue(){
	return secondDie.getValue();
    }

    public String toString(){
	return "firstDie(" + firstDie.getValue() + ") secondDie(" + secondDie.getValue() + ")";
    }
}