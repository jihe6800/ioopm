public class Driver {

    public static void main(String args[]){
	int[] lastFour = new int[4];
	lastFour[0] = 1;
	lastFour[1] = 2;
	lastFour[2] = 3;
	lastFour[3] = 4;
	Person p = new Person(92, 04, 25, lastFour);

	int[] anArray = p.getLastFourCopy();
	System.out.println("" + anArray[0] + anArray[1] + anArray[2] + anArray[3]);
	anArray[0] = 7;
	System.out.println("" + anArray[0] + anArray[1] + anArray[2] + anArray[3]);


	int[] myArray = p.getLastFour();
	System.out.println("" + myArray[0] + myArray[1] + myArray[2] + myArray[3]);
	myArray[0] = 7;
	System.out.println("" + myArray[0] + myArray[1] + myArray[2] + myArray[3]);


	int[] anotherArray = p.getLastFour();
	System.out.println("" + anotherArray[0] + anotherArray[1] + anotherArray[2] + anotherArray[3]);
	
	System.out.println(p.getBirthOfDate());
    }

}