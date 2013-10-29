import TrafficSimulation.Light;
import junit.framework.TestCase;

public class TestLight extends TestCase {

	Light light = new Light(4, 2);
	
	public void testStep() {
		light.step();
		light.step();
		light.step();
		assertTrue("step in Light does not add to time.", light.isGreen() == false);
	}
	
	public void testIsGreen() {
		assertTrue("isGreen in Light does not show green at the start of a simulation", true == light.isGreen());
		light.step();
		assertTrue("isGreen in Light changes to red before it should.", true == light.isGreen());
		light.step();
		assertTrue("isGreen in Light doesn't change to red when it should.", false == light.isGreen());
		light.step();
		light.step();
		light.step();
		assertTrue("isGreen in Light doesn't change to green when it should.", true == light.isGreen());	
	}
	
	public void testToString() {
		assertTrue("toString in Light doesn't show a correct representation of a green light.", "Light(Green)" == light.toString());
		light.step();
		light.step();
		light.step();
		assertTrue("toString in Light doesn't show a correct representation of a red light.", "Light(Red)" == light.toString());
	}
}
