package TrafficSimulation;

public class Car implements CarInterface {
    
    private int bornTime;
    private int destination; // 1 = turn, 0=straight
    private int currentPosition;
        

    public Car(int bornTime, int destination) {
	this.bornTime = bornTime;
	this.destination = destination;
    }

    public int getDestination() {
	return destination;
    }

    public int getBornTime() {
	return bornTime;
    }

    public int getCurrentPosition() {
	return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
	this.currentPosition = currentPosition;
    }

    public String toString() {
	return "#";
    }
}
