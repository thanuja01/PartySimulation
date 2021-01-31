/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package party;
import partyGivenClasses.Field;


/**
 *
 * @author richa
 */
public class Host extends Person {
    public Host() {
        
    }
    //moves hosts around the room by checking all adjacent locations until the first free space is found
    //When a free space is found the current location will be cleared before moving the host to the new free location
     public void act(Field theRoom){

          Person currentperson=theRoom.getObjectAt(currentLocation);
          
          if (theRoom.freeAdjacentLocation(currentLocation) != null){              
              theRoom.clearLocation(currentLocation);
              currentLocation =theRoom.freeAdjacentLocation(currentLocation);
              currentperson.setLocation(currentLocation.getRow(),currentLocation.getCol());
              theRoom.place(currentperson,currentLocation);
              
          
          }
    }
}
