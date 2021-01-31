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
public class Engineer extends Guests {
    public Engineer() {
        
    }
    //moves the engineer around the room
     public void act(Field theRoom){

   Person currentperson=theRoom.getObjectAt(currentLocation);
      ((Guests)currentperson).moveToBestLocation(theRoom);
    }
     
     //calculates the happiness level of the engineer
     //each adjacent location that has any type of person around it increases the engineer's happiness level by one
      public void setHappinessLevel(Field theRoom,Location location)
    {
        this.happinessLevel =0;
        if (theRoom.freeAdjacentLocation(location) != null){
            
            	Iterator<Location> adjacent = theRoom.adjacentLocations(location);
		while(adjacent.hasNext()) {
                    Location next = (Location) adjacent.next();
                
			if (theRoom.getObjectAt(next) instanceof Person ){
                             happinessLevel++;
                        
		}
		
                }
        }
    }
      //returns the happiness level of the engineer
        public int getHappinessLevel(){
     return happinessLevel ;
    }
}
