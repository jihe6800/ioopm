import java.util.Scanner;

public class MyDieTest {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	System.out.print("Number of sides: ");
	int sides = sc.nextInt();
	while(sides <= 0){
	System.out.print("Error. Number of sides: ");
	sides = sc.nextInt();
	}

	Die d = new Die(sides);

	int sumOfRolls = 0;
	int currentRoll = 0;

	for(int i=0;i<10;i++){
	    currentRoll = d.roll();
	    sumOfRolls += currentRoll;
	    System.out.println("You rolled: " + currentRoll);
	}

	System.out.println("That makes a total of: " + sumOfRolls);
	
	System.out.println(d.toString());

	Die die = new Die();
	die.roll();
	System.out.println(die.getValue());

	System.out.println(d.equals(die));
	
	PairOfDice Pair = new PairOfDice();
	
	for(int i=0;i<4;i++){
	Pair.roll();
	System.out.println("First: " + Pair.getFirstDieValue() + " Second: " + Pair.getSecondDieValue());
	System.out.println(Pair.toString());
	}
    }
}