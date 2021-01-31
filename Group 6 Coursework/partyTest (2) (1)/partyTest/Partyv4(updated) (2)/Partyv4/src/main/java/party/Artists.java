/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package party;
import partyGivenClasses.Field;
import partyGivenClasses.Location;
import java.util.Iterator;

/**
 *
 * @author richa
 */

public class Artists extends Guests {
    public Artists() {
        
    }
    //moves the artist in the simulation
    public void act(Field theRoom){

        Person currentperson=theRoom.getObjectAt(currentLocation);
      ((Guests)currentperson).moveToBestLocation(theRoom);
      
  }
    //returns the happiness level of the artist
    public int getHappinessLevel(){
     return happinessLevel ;
    }
    //calculates the happiness level of an artist at a certain lcoation
    //each adjacent location that has an artist or a host increases the happiness level by one
    public void setHappinessLevel(Field theRoom,Location location)
    {
        this.happinessLevel =0;
        if (theRoom.freeAdjacentLocation(location) != null){
            
            	Iterator<Location> adjacent = theRoom.adjacentLocations(location);
		while(adjacent.hasNext()) {
			Location next = (Location) adjacent.next();
			if (theRoom.getObjectAt(next) instanceof Artists ||theRoom.getObjectAt(next) instanceof Host ){
                             happinessLevel++;
                        }
		}
		
           
        }
    }
    
}
