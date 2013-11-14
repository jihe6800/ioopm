import junit.framework.TestCase;
import TrafficSimulation.Lane;
import customExceptions.OverflowException;
import TrafficSimulation.Car;

public class TestLane extends TestCase {

	Lane lane = new Lane(4);
	Car c1 = new Car(0, 1);
	Car c2 = new Car(1, 0);
	Car c3 = new Car(2, 0);
	
	public void testPutLast() {
		try {
			lane.putLast(c1);
			assertTrue("putLast in Lane doesn't put the given car at the first position in the lane.", lane.lastFree() == false);
			lane.putLast(c2);
			fail("putLast in Lane does not throw a OverflowException.");
		} catch (OverflowException e){
		}
	}
	
	public void testLastFree() {
		assertTrue("lastFree in Lane does not return true on a empty lane.", lane.lastFree() == true);
		lane.putLast(c1);
		assertTrue("lastFree in Lane does not return false when a car is on the last position.", lane.lastFree() == false);
	}
	
	public void testStep() {
		lane.putLast(c1);
		lane.step();
		assertTrue("step in Lane does not move the car at the position where they spawn", lane.lastFree() == true);
		lane.putLast(c2);
		lane.step();
		lane.step();
		assertTrue("step in Lane does not move the cars correctly (Assuming that getFirst in lane works)", lane.getFirst() == c1);
	}
	
	public void testGetFirst() {
		lane.putLast(c1);
		lane.step();
		lane.step();
		lane.step();
		lane.step();
		assertTrue("getFirst in Lane does not return the expected car.", lane.getFirst() == c1);
		assertTrue("getFirst in Lane does not remove the car.", lane.getFirst() == null);
	}
	
	public void testFristCar() {
		lane.putLast(c1);
		assertTrue("firstCar in Lane does not return null when the position is empty", lane.firstCar() == null);
		lane.step();
		lane.step();
		lane.step();
		assertTrue("firstCar in Lane doest not return the expected car.", lane.firstCar() == c1);
	}
	
	public void testRemoveFirst() {
		lane.putLast(c1);
		lane.step();
		lane.step();
		lane.step();
		lane.removeFirst();
		assertTrue("removeFirst in Lane does not remove the first car.", lane.firstCar() == null);
	}
	
	public void testGetLength() {
		assertTrue("getLength in Lane returns wrong length.", lane.getLength() == 4);
	}
	
	public void testToString() {
		assertTrue("toString in Lane doesn't show a empty lane when it's empty.", lane.toString().equals("Lane(E, E, E, E)"));
		lane.putLast(c1);
		lane.step();
		lane.step();
		lane.putLast(c2);
		assertTrue("toString in Lane doesn't move cars as expected.", lane.toString().equals("Lane(E, #, E, #)"));
		lane.step();
		lane.step();
		assertTrue("toString() in Lane doesn't move cars as expected.", lane.toString().equals("Lane(#, #, E, E)"));
	}
	
	
}
