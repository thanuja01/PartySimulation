/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package party;
import partyGivenClasses.Field;
import partyGivenClasses.Location;
import java.util.Iterator;
import static party.Guests.happinessLevel;

/**
 *
 * @author richa
 */
public class Scientist extends Guests {
    public Scientist() {
         
    }
    //moves the scientist around the party simulation
     public void act(Field theRoom){
        Person currentperson=theRoom.getObjectAt(currentLocation);
      ((Guests)currentperson).moveToBestLocation(theRoom);
      
  }
     
     //Calculates the happiness level of the scientist at a particular location
     //Each adjacent location to the scientist that is occupied by either an artist, host or scientist increases the happiness level of the scientist at the specified location by one
     public void setHappinessLevel(Field theRoom, Location location)
             
    {
         this.happinessLevel =0;
        if (theRoom.freeAdjacentLocation(location) != null){
            
            	Iterator<Location> adjacent = theRoom.adjacentLocations(location);
		while(adjacent.hasNext()) {
			Location next = (Location) adjacent.next();
			if (theRoom.getObjectAt(next) instanceof Artists ||theRoom.getObjectAt(next) instanceof Host  ||theRoom.getObjectAt(next) instanceof Scientist){
                             happinessLevel++;
                        }
		}
		
           
        }
    }
     
    
    public int getHappinessLevel(){
     return happinessLevel ;
    }
    
    
}
