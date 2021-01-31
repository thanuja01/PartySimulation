/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package party;

import PartyPackage.Field;
import PartyPackage.SimulatorView;
import PartyPackage.RandomGenerator;
import java.awt.Color;
import java.util.Random;
//import com.sun.prism.paint.Color;




/**
 *
 * @author richa
 */
public class Simulator {
    SimulatorView view;
    Field partyRoom;
    int seed = 1;
    
    public Simulator(int width, int height) {
          view = new SimulatorView(width,height);
          partyRoom = new Field(width, height);
         startSimulation();
          RandomGenerator.initialiseWithSeed(seed);
           
           
    }
    
   public static void main(String[] args){
    Simulator sim = new Simulator(50, 50);
   }
    public void populate() {
        partyRoom.clear();
       Host h1 = new Host();
        Artists a1 = new Artists();
        Scientist s1 = new Scientist();
        Engineer e1 = new Engineer(); 
       
   for(int r = 0; r<50; r++){
       for(int c = 0; c<50; c++){
           Random rd = RandomGenerator.getRandom();
           double rand = rd.nextDouble();
        if(rand < a1.getProb()){
           partyRoom.place(a1, r, c); 
        } else if((rand>a1.getProb()) && (rand<(e1.getProb() + a1.getProb()))){
            partyRoom.place(e1, r, c);
        }else if((rand>(e1.getProb() + a1.getProb())) && (rand<(e1.getProb()+a1.getProb()+s1.getProb()))){
           partyRoom.place(s1, r, c); 
        }else if((rand>(e1.getProb() + a1.getProb() + s1.getProb())) && (rand<=1)){
        partyRoom.place(h1, r, c);
        }
   }
   }
        view.setColor(Host.class, Color.YELLOW);
        view.setColor(Artists.class, Color.blue);
        view.setColor(Scientist.class, Color.GREEN);
        view.setColor(Engineer.class, Color.magenta);
        
        
   
        
    }
public void startSimulation(){
    populate();
    view.showStatus(4, partyRoom);
}


}

    



