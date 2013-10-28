    package TrafficSimulation;

import customExceptions.OverflowException;
import TrafficSimulation.Car;

public class Lane {
        
    private Car[] theLane;
    private int length;
    
    public Lane(int n) {
	theLane = new Car[n];
	this.length = n;
    }
    
    /** step moves all the cars one position forward in the array.  
     */

    public void step() {
	
	for(int i=this.getLength()-1;i>0;i--) {
	    
	    if (theLane[i] == null) {
		theLane[i]   = theLane[i-1];
		theLane[i-1] = null;
		
		if(theLane[i] != null){
		    theLane[i].setCurrentPosition(i);
		} 
		
	    } else {
		continue;
	    }
	    // Stega fram alla fordon (utom det på plats 0) ett steg
	    // (om det går). (Fordonet på plats 0 tas bort utifrån
	    // mm h a metoden nedan.)
	}
    }

    //public int getExceptions() {
    //	return laneExceptions;
    //}

    /** getFirst removes and gets the first car in the Lane.
     *
     *  @return Returns the first car in the Lane.
     */
    
    public Car getFirst() {
    	Car c = theLane[length-1];
    	theLane[length-1] = null;
    	return c;
    }
    
    /** removeFirst removes the Car at the first position in the Lane.
     */
    
    public void removeFirst() {
    	theLane[length-1] = null;
    }

    /** firstCar gets the first car in the Lane, without removing it.
     *
     * @return Returns the first car in the Lane.  
     */
    
    public Car firstCar() {
	
	if(theLane[length-1] == null){
	    return null;
	} else {
	    return theLane[length-1];
	}
     }
    
    /** lastFree returns true is the last position in a Lane is free.
     *
     *  @return Returns true if there is null stored in the last postion of the Lane, else false.
     */
    
    public boolean lastFree() {
	
	if(theLane[0] == null){
	    return true;
	} else {
	    return false;
	}
	// Returnera true om sist platsen ledig, annars false
    }

    /** putLast inserts a Car at the last position of a Lane if the spot is free.
     *
     * @param c c is a Car which is in the last position of a Lane.
     * @throws OverflowException is thrown when a Car needs to go into a Lane but the last
     * position is occupied.
     */
    
    public void putLast(Car c) throws OverflowException {
	
	if(theLane[0] == null){
	    theLane[0] = c;
	} else {
	    throw new OverflowException();
	} 
	
    }

    /** getLenght gets the lenght of the Lane.
     *
     * @return Returns the lenght of the Lane.
     */
    
    public int getLength(){
	return length;
    }

    /** toString builds a representation of the lane as a String.
     *
     * @return Returns a string which contains a representation of the lane as a String.
     */
    
    public String toString() {
	String tmp;
	String all = "Lane(";
	
	for(int i = this.getLength()-1;i>=0;i--){
	    
	    if(i == 0) {
		if(theLane[i] != null){
		    tmp = theLane[i].toString();
		    all = all + tmp;
		} else {
		    all = all + "E";
		}
	    } else {
		if(theLane[i] != null){
		    tmp = theLane[i].toString();
		    all = all + tmp + ", ";
		} else {
		    all = all + "E, ";
		}
	    }
	}
	return all + ")";
    }
}
