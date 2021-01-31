/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package party;
import partyGivenClasses.Location;
import partyGivenClasses.Field;

/**
 *
 * @author richa
 */
 public abstract class Person {
     //each persons currentlocation is stored in the currentLocation variable
    Location currentLocation;
    
    //sets the current location of a person
    public void setLocation(int row,int column){
        currentLocation = new Location(row,column);
    }
     public abstract void act(Field theRoom);
     
     
          
    
}
