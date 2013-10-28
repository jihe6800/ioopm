public class Die {
    private int numberOfSides;
    private int value;
    private int save = 0;

    public Die() {
	numberOfSides = 6;
	value = 0;
    }

    public void roll(){
	if(save != 1) {
	    value = (int) ((Math.random()*numberOfSides) + 1);
	} 
    }
    
    public int getValue(){
	return value;
    }

    public void setSave() {
	save = 1;
    }

    public int getSave() {
	return save;
    }

    public String toString() {
	return "rolled " + value;
    }

    


}