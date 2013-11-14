import java.util.Scanner;
import TrafficSimulation.TrafficSystem;

public class Simulation {

    
    public static void main(String [] args) {

	
	TrafficSystem ts = new TrafficSystem();

	ts.readParameters();
	
	Scanner sc = new Scanner(System.in);
	System.out.println("For how many steps do you want to test the simulation?");
	int steps = sc.nextInt();

	for(int i=0;i<steps;i++) {
	    ts.step();
	    System.out.println(ts.print());
	}
	ts.printStatistics();
    }
}