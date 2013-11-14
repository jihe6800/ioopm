import junit.framework.TestCase;
import TrafficSimulation.Car;

public class TestCar extends TestCase {

	Car car = new Car(3, 1);
	
	public void testGetDestination(){
		assertTrue(1 == car.getDestination());
	}
	
	public void testGetBornTime() {
		assertTrue(3 == car.getBornTime());
	}
	
	public void testGetCurrentPosition() {
		car.setCurrentPosition(0);
		assertTrue(0 == car.getCurrentPosition());
	}
	
	public void testSetCurrentPosition() {
		car.setCurrentPosition(1);
		assertTrue(1 == car.getCurrentPosition());
	}
	
	public void testToString() {
		assertTrue("#" == car.toString());
	}
	
}
