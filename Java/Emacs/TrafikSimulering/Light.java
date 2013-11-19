package TrafficSimulation;

public class Light implements LightInterface {
    private int period;
    private int time = 0;
    private int green;
    
    public Light(int period, int green) {
	this.period = period;
	this.green = green;
    }
    
    public void step() {
	if(time == period) {
	    time = 0;
	} else {
	    time++;
	}
    }
    
    public boolean isGreen() {
	return time<green;
    }

    
    public String toString() {

	if(this.isGreen()) {
	    return "Light(Green)";
	} else {
	    return "Light(Red)";
	}
    }
    
}
