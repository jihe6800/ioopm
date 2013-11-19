package TrafficSimulation;

import TrafficSimulation.Car;
import customExceptions.OverflowException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TrafficSystem implements TrafficSystemInterface {
   
    private LaneInterface r0;
    private LaneInterface r1;
    private LaneInterface r2;
    private LightInterface s1;
    private LightInterface s2;

   
    private int arrivalRate;
    private int carTurn;
    private int fullLane = 0;
    private int fullSlipRoad = 0;
    private int maxGoThroughTime = 0;
    private int averageGoThroughTime = 0;
    private int totalGoThroughTime = 0;
    private int carPassed = 0;
    private int time = 0;

    public TrafficSystem() {}

    public void readParameters() {
	Properties properties = new Properties();
	try {
	    properties.load(new FileInputStream("./Parameters.properties"));

	    r0 = new Lane(Integer.parseInt(properties.getProperty("r0")));
	    r1 = new Lane(Integer.parseInt(properties.getProperty("r1")));
	    r2 = new Lane(Integer.parseInt(properties.getProperty("r2")));
	    s1 = new Light(Integer.parseInt(properties.getProperty("s1period")), 
			   Integer.parseInt(properties.getProperty("s1green")));
	    s2 = new Light(Integer.parseInt(properties.getProperty("s2period")), 
			   Integer.parseInt(properties.getProperty("s2green")));
	    
	    arrivalRate = Integer.parseInt(properties.getProperty("arrivalRate"));
	    carTurn = Integer.parseInt(properties.getProperty("carTurn"));
	   
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public int goThroughTime(CarInterface c) {
	int carGoThroughTime = time - c.getBornTime();
	return carGoThroughTime;
    }

    public boolean carArrival(int arrivalRate) {
	
	if((Math.random()*100 <= arrivalRate)) {
	    return true;
	} else {
	    return false;
	}
	
    }

    public int max(int a, int b) {
	if (a >= b) {
	    return a;
	} else {
	    return b;
	}
    }

    public CarInterface spawnCar(){
	
	if(this.carArrival(arrivalRate)) {
	    
	    if(Math.random()*100 <= carTurn) {
		CarInterface car = new Car(time, 1);
		return car;
	    } else {
		CarInterface car = new Car(time, 0);
		return car;
	    }
	} else {
	    return null;
	}
    }

    public void step() {

	s1.step();
	s2.step();

	if(r1.firstCar() != null && s1.isGreen()) {
	    carPassed++;
	    CarInterface c = r1.getFirst();
	    totalGoThroughTime += goThroughTime(c);
	    averageGoThroughTime = totalGoThroughTime/carPassed;
	    maxGoThroughTime = max(maxGoThroughTime, goThroughTime(c));
	}

	if(r2.firstCar() != null && s2.isGreen()) {
	    carPassed++;
	    CarInterface c = r2.getFirst();
	    totalGoThroughTime += goThroughTime(c);
	    averageGoThroughTime = totalGoThroughTime/carPassed;
	    maxGoThroughTime = max(maxGoThroughTime, goThroughTime(c));
	}

       	r1.step();
	r2.step();

	try {
	    if(r0.firstCar() != null){
		if(r0.firstCar().getDestination() == 1){
		    CarInterface car = r0.firstCar();
		    car.setCurrentPosition(0);
		    r2.putLast(car);
		    r0.getFirst();
		} else {
		    CarInterface car = r0.firstCar();
		    car.setCurrentPosition(0);
		    r1.putLast(car);
		    r0.getFirst();
		} 
	    }
	} catch (OverflowException e) {
	    fullSlipRoad++;
	} finally {
	    r0.step();
	    try  {
		r0.putLast(this.spawnCar());
	    } catch (OverflowException e) {
		fullLane++;
	    } finally {

	time++;
	    }
	}
    }

    public void printStatistics() {

	System.out.println("Average time for a car passing the system:" + averageGoThroughTime);
	System.out.println("Maximal time for a car passing the system:" + maxGoThroughTime);
	System.out.println("Number of steps which a slip road were full:" + fullSlipRoad);
	System.out.println("Number of steps which a new car couldn't enter the simulation:" + fullLane);
	System.out.println("Number of cars which passed the simulation:" + carPassed);
    }

    public String print() {

	return s1.toString() + "R1:" + r1.toString() + "R0:" + r0.toString() + 
	"\n" + s2.toString() + "R2:" + r2.toString() + "\n";
    }

}



