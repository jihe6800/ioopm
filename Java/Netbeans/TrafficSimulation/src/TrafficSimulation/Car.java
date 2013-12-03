/** Car is a car which contains a bornTime, currentPosition and a destination. 
 *  bornTime and destination are arguments for the constructor, 1 is added to 
 *  the currentPosition each time the car moves one step.
 *   
 *  Jimmy Helmersson & Matlida Trodin
 *
 */

package TrafficSimulation;

public class Car{
    
	private int bornTime;
    private int destination; // 1 = turn, 0=straight
    private int currentPosition;
        

    public Car(int bornTime, int destination) {
    	if(destination > 1 && destination < 0){
    		System.out.println("Invalid destination, 1 = turn and 0 = straight.");
    	} else {
	this.bornTime = bornTime;
	this.destination = destination;
    	}	
    }

    /** getDestination gets the destination for the current car. 
     *
     * @return getDestination returns 1 if the car is going to turn, else 0.
     *
     */

    public int getDestination() {
	return destination;
    }

    /** getBornTime gets the bornTime for the current car.
     *
     * @return getBornTime returns the bornTime of the current car.
     *
     */

    public int getBornTime() {
	return bornTime;
    }

    /** getCurrentPosition gets the currentPosition of the current car.
     *
     * @return getCurrentPosition returns the currentPosition of a car.
     *
     */

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
