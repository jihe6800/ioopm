import TrafficSimulation.Light;
import junit.framework.TestCase;

public class TestLight extends TestCase {

	Light light = new Light(4, 2);
	
	public void testStep() {
	}
	
	public void testIsGreen() {
		assertTrue(true == light.isGreen());
		light.step();
		assertTrue(true == light.isGreen());
		light.step();
		assertTrue(false == light.isGreen());
		light.step();
		light.step();
		light.step();
		assertTrue(true == light.isGreen());	
	}
	
	public void testToString() {
		assertTrue("Light(Green)" == light.toString());
		light.step();
		light.step();
		light.step();
		assertTrue("Light(Red)" == light.toString());
	}
}
