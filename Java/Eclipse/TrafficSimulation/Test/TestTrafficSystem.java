import TrafficSimulation.Car;
import TrafficSimulation.Lane;
import TrafficSimulation.Light;
import TrafficSimulation.TrafficSystem;
import junit.framework.TestCase;

public class TestTrafficSystem extends TestCase {
		    
			
		    Lane r0Turn = new Lane(3);
		    Lane r1Turn = new Lane(3);
		    Lane r2Turn = new Lane(3);
		    Light s1Turn = new Light(4, 2);
		    Light s2Turn = new Light(4, 2);

			
		    Lane r0Straight = new Lane(3);
		    Lane r1Straight = new Lane(3);
		    Lane r2Straight = new Lane(3);
		    Light s1Straight = new Light(4, 2);
		    Light s2Straight = new Light(4, 2);

		    
		    int arrivalRate = 100;
		    int carTurnTrue = 100;
		    int carTurnFalse = 0;
		    
		    TrafficSystem tsTurn = new TrafficSystem(r0Turn, r1Turn, r2Turn, s1Turn, s2Turn, arrivalRate, carTurnTrue);
		    TrafficSystem tsStraight = new TrafficSystem(r0Straight, r1Straight, r2Straight, s1Straight, s2Straight, arrivalRate, carTurnFalse);
		    
		    public void testCarArrival() {
		    	assertTrue("carArrival in TrafficSystem does not return true when it is a 100% chance for a car to spawn.", tsTurn.carArrival(arrivalRate) == true);
		    	int carA = 0;
		    	assertTrue("carArrival in TrafficSystem does not return false when it is 0% chance for a car to spawn.", tsTurn.carArrival(carA) == false);
		    }
		    
		    public void testMax() {
		    	assertTrue("max in TrafficSystem does not return the highest value.", tsTurn.max(1, 2) == 2);
		    	assertTrue("max in TrafficSystem does not return the highest value.", tsTurn.max(4, 2) == 4);
		    	assertTrue("max in TrafficSystem does not return the highest value.", tsTurn.max(2, 2) == 2);
		    }
		    
		    public void testSpawCar() {
		    	assertTrue("spawnCar in TrafficSystem doesn't spawn a car with the correct destination (Expected destination 1).", tsTurn.spawnCar().getDestination() == 1);
		    	assertTrue("spawnCar in TrafficSystem doesn't spawn a car with the correct destination (Expected destination 0).", tsStraight.spawnCar().getDestination() == 0);
		    	assertTrue("spawnCar in TrafficSystem doesn't spawn a car with the correct bornTime.", tsTurn.spawnCar().getBornTime() == 0);
		    }
		    
		    public void testStep() {
		    	
		    	for(int i=0;i<6;i++){
		    		tsTurn.step();
		    		tsStraight.step();
		    	}
		    	assertTrue("step in TrafficSystem doesn't spawn cars correctly", r0Turn.lastFree() == false);
		    	assertTrue("step in TrafficSystem doesn't put cars in the right lane when turning.", r2Turn.lastFree() == false);
		    	assertTrue("step in TrafficSystem doesn't put cars in the right lane when going straight.", r1Straight.lastFree() == false);
		    	int carTurn = r2Turn.firstCar().getBornTime();
		    	int carStraight = r1Straight.firstCar().getBornTime();
		    	assertTrue("step in TrafficSystem remove cars from the first position of the turn-slip road when the light is red.", r2Turn.firstCar().getBornTime() == carTurn);
		    	assertTrue("step in TrafficSystem remove cars from the first position of the straight-slip road when the light is red.", r1Straight.firstCar().getBornTime() == carStraight);	
		    	for(int i=0;i<4;i++) {
		    		tsTurn.step();
		    		tsStraight.step();
		    	}
		    	assertTrue("step in TrafficSystem doesn't remove cars from the first position of the turn-slip road when the light is green.", r2Turn.firstCar().getBornTime() != carTurn);
		    	assertTrue("step in TrafficSystem doesn't remove cars from the first position of the straight-slip road when the light is green.", r1Straight.firstCar().getBornTime() != carStraight);
			    
		    }
		    
		    public void testPrint() {
		    	assertEquals("Print in TrafficSytem doesn't show the expected output on all empty lanes.", tsTurn.print(), "Light(Green)R1:Lane(E, E, E)R0:Lane(E, E, E)\nLight(Green)R2:Lane(E, E, E)\n");
		    	tsTurn.step();
		    	assertEquals("Print in TrafficSystem doesn't show when a car is spawned on r0.", tsTurn.print(), "Light(Green)R1:Lane(E, E, E)R0:Lane(E, E, #)\nLight(Green)R2:Lane(E, E, E)\n");
		    	tsTurn.step();
		    	tsTurn.step();
		    	tsTurn.step();
		    	assertEquals("Print int TrafficSystem doesn't show when the light switches to red.", tsTurn.print(), "Light(Red)R1:Lane(E, E, E)R0:Lane(#, #, #)\nLight(Red)R2:Lane(E, E, #)\n");	
		    	tsStraight.step();
		    	tsStraight.step();
		    	tsStraight.step();
		    	tsStraight.step();
		    	assertEquals("Print in TrafficSystem doesn't show when cars switches lanes.", tsStraight.print(), "Light(Red)R1:Lane(E, E, #)R0:Lane(#, #, #)\nLight(Red)R2:Lane(E, E, E)\n");
		    }
		    
		    public void testGoThroughTime() {
		    	
		    	for(int i=0;i<6;i++) {
		    		tsTurn.step();
		    	}	
		    	Car car = r2Turn.firstCar();
		    	assertEquals("goThroughTime in TrafficSystem doesn't calculate the correct time.", tsTurn.goThroughTime(car), 6);
		    }
		    
		    public void testGetAverageGoThroughTime() {
		    	
		    	for(int i=0;i<20;i++){
		    		tsTurn.step();
		    	}
		    	
		    	assertTrue("getAverageGoThroughTime in TrafficSystem doesn't return the correct time. There is a error in step", tsTurn.getAverageGoThroughTime() == 12);
		    }
		    
		    public void testGetMaxGoThroughTime() {
		    	
		    	for(int i=0;i<20;i++) {
		    		tsTurn.step();
		    	}
		    	
		    	assertTrue("getMaxGoThroughTime in TrafficSystem doesn't return the correct time. There is an error in step.", tsTurn.getMaxGoThroughTime() == 16);   	
		    }
		    
		    public void testGetFullSlipRoad() {
		    	
		    	for(int i=0;i<20;i++) {
		    		tsTurn.step();
		    	}
		    	
		    	assertTrue("getFullSlipRoad in TrafficSystem doesn't return the correct time. There is an error in step.", tsTurn.getFullSlipRoad() == 9);
		    }
		    
		    public void testGetFullLane() {
		    	
		    	for(int i=0;i<20;i++) {
		    		tsTurn.step();
		    	}
		    	
		    	assertTrue("getFullLane in TrafficSystem doesn't return the correct time. There is an error in step.", tsTurn.getFullLane() == 9);
		    }
		    
		    public void testGetCarPassed() {
		    	
		    	for(int i=0;i<20;i++) {
		    		tsTurn.step();
		    	}
		    	
		    	assertTrue("getCarPassed in TrafficSystem doesn't return the correct time. There is an error in step.", tsTurn.getCarPassed() == 5);
		    }
		    
}
