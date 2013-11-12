public class Die {
    private int numberOfSides;
    private int value;
    
    public Die(){
	numberOfSides = 6;
    }
    
    public Die(int numberOfSides) {
	if(numberOfSides <= 0) {
	    System.out.println("You need to choose 1 or more sides.");
	} else {
	    this.numberOfSides = numberOfSides;
	}
    }
    
    public String toString(){
	return "Die(" + value + ")";
    }
    
    public int roll() {
	return value = (int) ((Math.random()*numberOfSides) + 1);
    }
    
    public int getValue() {
	return value;
    }

    public int getSides() {
	return numberOfSides;
    }
    
    public void setSides(int sides) {
	numberOfSides = sides;
    }
    
    public boolean equals(Die otherDie){
	if(this.getSides() == otherDie.getSides()){
	    return true;
		} else {
	    return false;
	}
    }

    public boolean same(Die otherDie){
	if(this == otherDie){
	    return true;
	} else {
	    return false;
	}
    }
}