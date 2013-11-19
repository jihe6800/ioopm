/** TrafficSystem simulates the scenario. This class creates all the Lights, Lanes and
 *  Cars. The cunstructor takes the arguments arrivalRate, carTurn, the length of all lanes,
 *  green for the lights and period for the lights. 
 *  It also collects all data, which is: everytime a SlipRoad is full, everytime
 *  the whole lane is full, maxGoThroughTime for a car, averageGoThroughTime for a car
 *  and carPassed, which is the amount of cars which passed the simulation.
 *
 *  Jimmy Helmersson & Matlida Trodin
 */

package TrafficSimulation;

import TrafficSimulation.Car;
import customExceptions.OverflowException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public interface TrafficSystemInterface {

    /** readParameters gets all values for the lenght of the lanes, period and green for the
     *  Lights, the arrivalRate and carTurn in percentage from a properties file.
     */

    public void readParameters();

    
    /** Calculates the time it took for a car to drive through the simulation.
     *
     *  @param c is a car which have passed the simulation. 
     */

    public int goThroughTime(CarInterface c);


    /** Calculates if a car will spawn at a certain step or not.
     *
     *  @param arrivalRate is an int which is the chance, in percent, for
     *  a car to spawn at the beginning of the simulation.
     *  @return Returns true if a random number between 1-100 is below arrivalRate, else false.
     */

    public boolean carArrival(int arrivalRate);


    /** Max returns the max value of two integers.
     *
     *  @param a is an int.
     *  @param b is an int.
     *  @return Returns a if b i equal or larger, else b.
     */

    public int max(int a, int b);


    /** Creates a car if all conditions are true with destination set to 1 or 0, else returns null.
     *
     * @return Returns a car with destination set to 1 if carArrival is true and if a randomed number
     * is less than carTurn, if carArrival is true and carTurn is greater than a randomed number it returns
     * a car with destionation set to 0, else returns null.
     */

    public CarInterface spawnCar();


    /** Steps all the other objects with their step methods. Step also moves cars between lanes depending on 
     *  their destinations, also removes cars if the light is green and the car is at the end of the simulation.
     *  Step also collects the time it takes for different cars to drive through the simulation, how many cars
     *  which have passed, how many time a slip road were full and how many time the whole simulation were full.
     */
        
    public void step();


    /** Prints all the statistics collected so far.
     */

    public void printStatistics();


    /** Builds a string for the representation of the simulation, with the other obejcts toString
     *  methods.
     *
     * @param Returns a string representation of the simulation.
     */

    public String print();
}