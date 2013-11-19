/** Car is a car which contains a bornTime, currentPosition and a destination. 
 *  bornTime and destination are arguments for the constructor, 1 is added to 
 *  the currentPosition each time the car moves one step.
 *   
 *  Jimmy Helmersson & Matlida Trodin
 *
 */

package TrafficSimulation;

public interface CarInterface {

    /** Gets the destination of the current car. 
     *
     * @return Returns 1 if the car is going to turn, else 0.
     */

    public int getDestination();


    /** Gets the bornTime for the current car.
     *
     * @return Returns the bornTime of the current car.
     */

    public int getBornTime();


    /** Gets the currentPosition of the current car.
     *
     * @return Returns the currentPosition of the car.
     */

    public int getCurrentPosition();

    
    /** Sets the currentPosition of the car to the currentPosition which is the argument.
     *
     * @param currentPosition is the new currentPosition of the car.
     */
    
    public void setCurrentPosition(int currentPosition);

    
    /** Returns a string presentation of the current lane.
     *
     * @param Returns a string representation of the current lane.
     */

    public String toString();

}