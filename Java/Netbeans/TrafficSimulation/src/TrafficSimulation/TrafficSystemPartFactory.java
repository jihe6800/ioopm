/*package TrafficSimulation;

public class TrafficSystemPartFactory {

	public TrafficSystemPart getTrafficSystemPart(String partType, int length) {
		
		if(partType.equalsIgnoreCase("LANE")) {
			return new Lane(length);		
		} else {
			return null;
		}
	}
	
	// x can either be bornTime or period, y can either be destination or green
	public TrafficSystemPart getTrafficSystemPart(String partType, int x, int y) {
		
		if (partType.equalsIgnoreCase("CAR")) {
			return new Car(x, y);
		} else if (partType.equalsIgnoreCase("LIGHT")) {
			return new Light(x, y);
		} else {
			return null;
		}
	}
}
*/