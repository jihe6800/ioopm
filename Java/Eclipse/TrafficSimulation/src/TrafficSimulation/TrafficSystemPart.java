package TrafficSimulation;
public interface TrafficSystemPart {
	String toString();
	void step();
	Car firstCar();
}
