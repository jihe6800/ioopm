package TrafficSimulation;

import customExceptions.OverflowException;
import TrafficSimulation.Car;

public class Lane implements LaneInterface {
        
    private CarInterface[] theLane;
    private int length;
    private int laneExceptions = 0;
    
    
    public Lane(int n) {
	theLane = new CarInterface[n];
	this.length = n;
    }
    
    
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
	}
    }

    public CarInterface getFirst() {
	CarInterface car = theLane[length-1];
	theLane[length-1] = null;
	return car;
	
    }

    
    public CarInterface firstCar() {
	
	if(theLane[length-1] == null){
	    return null;
	} else {
	    return theLane[length-1];
	}
     }
    
    
    public boolean lastFree() {
	
	if(theLane[0] == null){
	    return true;
	} else {
	    return false;
	}
    }

    
    public void putLast(CarInterface c) throws OverflowException {
	
	if(theLane[0] == null){
	    theLane[0] = c;
	} else {
	    throw new OverflowException();
	} 
	
    }

    
    public int getLength(){
	return length;
    }

    
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
