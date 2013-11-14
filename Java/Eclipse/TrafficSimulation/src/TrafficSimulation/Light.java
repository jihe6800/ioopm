/** Light is a traffic light which can show green or red. 
 *
 * Jimmy Helmersson, Matilda Trodin
 * 
 */

package TrafficSimulation;

public class Light {
    private int period;
    private int time = 0;
    private int green;
    
    public Light(int period, int green) {
	this.period = period;
	this.green = green;
    }
    
    /** step adds one the the intern time, if time reaches period it's set to 0. */
    public void step() {
	if(time == period) {
	    time = 0;
	} else {
	    time++;
	}
    }
    /** isGreen returns true if the current Light is green.
     *  @return isGreen returns true if time is less than green, otherwise false.	
     *
     */
    public boolean isGreen() {
	return time<green;
    }

    /** toString makes the representation of a Light as a string.
     *
     *  @return Returns a string which indicates that the Light is green if isGreen = true, else it returns
     * a string which indicates that the Light is red.
     *
     */
    
    public String toString() {

	if(this.isGreen()) {
	    return "Light(Green)";
	} else {
	    return "Light(Red)";
	}
    }
    
}
