/*
Modell för trafiksimulering
===========================

Följande klasser skall användas:

Car representerar fordon
ankomsttid och destination som sätts när objektet skapas

Light representerar ljussignaler
Se nedan
Lane representerar ett vägavsnitt
En väg representeras av en array där varje element
antingen är tomt eller innehåller en referens till
ett bil-objekt.
OBS: Klassen Lane påminner om kömekanismen i föregående
uppgift men den skiljer sig också i flera avseende.
I denna klass ställs nya bilar i ena änden av ARRAYEN
och inte närmast efter den som finns där. I kömekanismen
var alltid elementen (kunderna) samlade medan bilarna
i denna klass kan vara utspridda över hela arrayen.
TrafficSystem
Definierar de komponeneter dvs de vägar och signaler
som ingår i systemet. Se vidare nedan

Simulation
main-metod som driver simuleringen


Den situation som skall simuleras ser schematiskt ut enligt



C             B                                A
s1<----r1-----<---------r0---------------------
s2<----r2-----<


En fil (vägsträcka) r0 delar sig vid B i två filer r1 och r2.
Signal s1 kontrollerar fil r1 och och signal s2 fil r2.
Bilar uppstår vid A. Sannolikheten att en bil skall komma till A
vid ett visst tidsteg kallas ankomstintensiteten.

Vid ett tidssteg rör sig bilarna ett steg framåt (om platsen framför
är ledig). Vid C tas bilarna ut från filerna om repektive
signal är grön. Vid B tas bilar ut från r0 och läggs in på r1 eller r2
beroende på destination (och om platsen är ledig).

Anm: Man skulle kunna representera systemet med två Lane-objekt
men då måste man ha något sätt att representera en "avtappning"
(där svängfilen börjar). Med den här valda representationen
blir Lane-klassen enklare.
*/



// Skiss av klasser. Angivna klasser och metoder skall finnas.
// Det är tillåtet att tillfoga fler attribut och metoder


     /** TrafficSystem simulates the scenario. This class creates all the Lights, Lanes and
      *  Cars. 
      *
      *  Jimmy Helmersson & Matlida Trodin
      */

package TrafficSimulation;

import TrafficSimulation.Car;
import customExceptions.OverflowException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TrafficSystem {
   
    private Lane r0;
    private Lane r1;
    private Lane r2;
    private Light s1;
    private Light s2;

   
    private int arrivalRate;
    private int carTurn;

    private int fullLane = 0;
    private int fullSlipRoad = 0;
    private int maxGoThroughTime = 0;
    private int averageGoThroughTime = 0;
    private int totalGoThroughTime = 0;
    private int carPassed = 0;
    private int time = 0;

    public TrafficSystem() {}

    /** readParameters gets all values for the lenght of the lanes, period and green for the
     *  Lights, the arrivalRate and carTurn percentage from a properties file.
     *
     */

    public void readParameters() {
	Properties properties = new Properties();
	try {
	    properties.load(new FileInputStream("./Parameters.properties"));

	    r0 = new Lane(Integer.parseInt(properties.getProperty("r0")));
	    r1 = new Lane(Integer.parseInt(properties.getProperty("r1")));
	    r2 = new Lane(Integer.parseInt(properties.getProperty("r2")));
	    s1 = new Light(Integer.parseInt(properties.getProperty("s1period")), 
			   Integer.parseInt(properties.getProperty("s1green")));
	    s2 = new Light(Integer.parseInt(properties.getProperty("s2period")), 
			   Integer.parseInt(properties.getProperty("s2green")));
	    
	    arrivalRate = Integer.parseInt(properties.getProperty("arrivalRate"));
	    carTurn = Integer.parseInt(properties.getProperty("carTurn"));
	   
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /** goThroughTime calculates the time it took for a car to drive through the
     *  simulation.
     *
     *  @param c c is a car which have passed the simulation. 
     */

    public int goThroughTime(Car c) {
	int carGoThroughTime = time - c.getBornTime();
	return carGoThroughTime;
    }

    /** carArrival calculates is a car will spawn a certain step or not.
     *
     *  @param arrivalRate arrivalRate is an int which is the chance, in percent, for
     *  a car to spawn at the beginning of the simulation.
     *  @return Returns true if a random number between 1-100 is below arrivalRate, else true.
     */

    public boolean carArrival(int arrivalRate) {
	
	if((Math.random()*100 <= arrivalRate)) {
	    return true;
	} else {
	    return false;
	}
	
    }

    /** Max returns the max value of two integers.
     *
     *  @param a a is an int.
     *  @param b b is an int.
     *  @return Returns a if b i equal or larger, else returns b.
     */

    public int max(int a, int b) {
	if (a >= b) {
	    return a;
	} else {
	    return b;
	}
    }

    /** spawnCar makes a car if all conditions are true with destination set to 1 or 0, else returns null
     *
     * @return Returns a car with destination set to 1 if carArrival is true and if a randomed number
     * is less than carTurn, if carArrival is true and carTurn is greater than a randomed number it returns
     * a car with destionation set to 0, else returns null.
     */

    public Car spawnCar(){
	
	if(this.carArrival(arrivalRate)) {
	    
	    if(Math.random()*100 <= carTurn) {
		Car car = new Car(time, 1);
		return car;
	    } else {
		Car car = new Car(time, 0);
		return car;
	    }
	} else {
	    return null;
	}
    }

    /** step steps all the other classes with their step methods. Step also moves car between lanes depending on 
     *  their destinations, also removes cars if the Light is green and the car is at the end of the simulation.
     *  Step also collects the time it takes for different cars to drive through the simulation and how many cars
     *  which have passed.
     *
     */
        
    public void step() {

	s1.step();
	s2.step();

	if(r1.firstCar() != null && s1.isGreen()) {
	    carPassed++;
	    Car c = r1.getFirst();
	    totalGoThroughTime += goThroughTime(c);
	    averageGoThroughTime = totalGoThroughTime/carPassed;
	    maxGoThroughTime = max(maxGoThroughTime, goThroughTime(c));
	}

	if(r2.firstCar() != null && s2.isGreen()) {
	    carPassed++;
	    Car c = r2.getFirst();
	    totalGoThroughTime += goThroughTime(c);
	    averageGoThroughTime = totalGoThroughTime/carPassed;
	    maxGoThroughTime = max(maxGoThroughTime, goThroughTime(c));
	}

       	r1.step();
	r2.step();

	try {
	    if(r0.firstCar() != null){
		if(r0.firstCar().getDestination() == 1){
		    Car car = r0.firstCar();
		    car.setCurrentPosition(0);
		    r2.putLast(car);
		    r0.getFirst();
		} else {
		    Car car = r0.firstCar();
		    car.setCurrentPosition(0);
		    r1.putLast(car);
		    r0.getFirst();
		} 
	    }
	} catch (OverflowException e) {
	    fullSlipRoad++;
	} finally {
	    r0.step();
	    try  {
		r0.putLast(this.spawnCar());
	    } catch (OverflowException e) {
		fullLane++;
	    } finally {

	time++;
	    }
	}
    }

    /** printStatistics prints all the statistics collected so far.
     *
     */

    public void printStatistics() {

	System.out.println("Average time for a car passing the system:" + averageGoThroughTime);
	System.out.println("Maximal time for a car passing the system:" + maxGoThroughTime);
	System.out.println("Number of steps which a slip road were full:" + fullSlipRoad);
	System.out.println("Number of steps which a new car couldn't enter the simulation:" + fullLane);
	System.out.println("Number of cars which passed the simulation:" + carPassed);
    }

    /** print builds a string for the representation of the simulation.
     */

    public String print() {

	return s1.toString() + "R1:" + r1.toString() + "R0:" + r0.toString() + 
	"\n" + s2.toString() + "R2:" + r2.toString() + "\n";
    }

}



