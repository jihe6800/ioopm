/** Light is a trafficlight which can show green or red. it contains a intern
 *  time, a period and a green.
 *
 * Jimmy Helmersson & Matilda Trodin
 */

package TrafficSimulation;

public interface LightInterface {

    /** Adds one to the intern time, if time reaches period it's set to 0.
     */

    public void step();


    /** Returns true if the current light is green.
     *  @return Returns true if time is less than green, otherwise false.	
     */

    public boolean isGreen();


    /** Creates a representation of a light as a string.
     *
     *  @return Returns a string which indicates that the Light is green if isGreen = true, else it returns
     * a string which indicates that the Light is red.
     */

    public String toString();
}
