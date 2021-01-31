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
abstract public class Guests extends Person {
    
    public static int happinessLevel;
    
    abstract public void act(Field theRoom);
    
    abstract public void setHappinessLevel(Field theRoom,Location location);
    
   abstract public int getHappinessLevel();
       
    //Works out the best possible space for a guest 
   // Takes into account the window which is how many spaces a guest can move away from its current location
   // The happiness level is calculated for each potential empty space for the guest to move to 
   //The guest will be moved to whichever space has the highest happiness level
    public void moveToBestLocation(Field theRoom){
        Iterator<Location> available = theRoom.adjacentLocations(currentLocation,ModelConstants.Window);
        Location bestlocation = currentLocation;
        Person thisperson = theRoom.getObjectAt(currentLocation);
     ((Guests)thisperson).setHappinessLevel(theRoom,currentLocation);
        int hlevel = ((Guests)thisperson).getHappinessLevel();

       while(available.hasNext()){        
           
           Location nextlocation =(Location)available.next();
           if((theRoom.getObjectAt(nextlocation) == null)){
                                     
                              
              ((Guests )thisperson).setHappinessLevel(theRoom,nextlocation);
              //System.out.println(();
              if (((Guests)thisperson).getHappinessLevel()>hlevel){
              hlevel =  ((Guests)thisperson).getHappinessLevel();
              bestlocation = nextlocation;
              }

            }
          
           
           }
     // System.out.println(((Guests)thisperson).getHappinessLevel());
       if (bestlocation!= currentLocation){
           theRoom.clearLocation(currentLocation);
           thisperson.setLocation(bestlocation.getRow(),bestlocation.getCol());
           
           theRoom.place(thisperson, bestlocation);
       }
    }
}
