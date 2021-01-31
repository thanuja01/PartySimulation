/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package party;

import partyGivenClasses.Field;
import partyGivenClasses.SimulatorView;
import partyGivenClasses.RandomGenerator;
import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;


/**
 *
 * @author richa
 */
public class Simulator implements Runnable{
//creates a view of the simulator
    SimulatorView view;
    //creates a field of the simulator
    Field partyRoom;
    int seed;
    // a matrix to store the locations of every person initialised 
    public static Person[][] people = new Person[ModelConstants.Height][ModelConstants.Width];
    //an arraylist to store all the people that are created
    public static ArrayList<Person> peopleCollection;
    //the current step of the simulation
    public static int currentStep;

    //constructs the simulator with the dimensions passed through the parameter
    //if the values in the parameter are less than 0 then the model constant values will be used
    //runs the simulator for a certain number of steps according to user input
    public Simulator(int width, int height) {
       
        if (width <= 0 && height <= 0) {
            width = ModelConstants.Width;
            height = ModelConstants.Height;
        }
        peopleCollection = new ArrayList<Person>();
        view = new SimulatorView(width, height);
        partyRoom = new Field(width, height);
        System.out.println(width +","+ height);
        currentStep = 0;
        RandomGenerator.initialiseWithSeed(seed);
        simulate(ModelConstants.NumberofSteps);
        

    }
//the main method which initialises the simulator and the GUI
    public static void main(String[] args) {
         GUI button = new GUI();
        Simulator sim = new Simulator(ModelConstants.Width, ModelConstants.Height);
       
    }

//this creates all the people that will be in the party
    // in every space available in the party room, a guest or host will be created using the corresponding creation probability
    //a colour is set for each type of person
    public void populate() {
        partyRoom.clear();

        for (int r = 0; r < ModelConstants.Height; r++) {
            for (int c = 0; c < ModelConstants.Width; c++) {
                Random rd = RandomGenerator.getRandom();
                double rand = (rd.nextDouble()) * 100;

                if (rand < ModelConstants.ArtistProbability) {
                    people[r][c] = new Artists();
                    peopleCollection.add(people[r][c]);
                    partyRoom.place(people[r][c], r, c);
                    people[r][c].setLocation(r, c);

                } else if (rand > ModelConstants.ArtistProbability && rand < (ModelConstants.EngineerProbability + ModelConstants.ArtistProbability)) {
                    people[r][c] = new Engineer();
                    peopleCollection.add(people[r][c]);
                    partyRoom.place(people[r][c], r, c);
                    people[r][c].setLocation(r, c);

                } else if (rand > (ModelConstants.EngineerProbability + ModelConstants.ArtistProbability)
                        && rand < (ModelConstants.EngineerProbability + ModelConstants.ArtistProbability + ModelConstants.ScientistProbability)) {
                    people[r][c] = new Scientist();
                    peopleCollection.add(people[r][c]);
                    partyRoom.place(people[r][c], r, c);
                    people[r][c].setLocation(r, c);
                } else if (rand > (ModelConstants.EngineerProbability + ModelConstants.ArtistProbability + ModelConstants.ScientistProbability) && rand <= ModelConstants.EngineerProbability + ModelConstants.ArtistProbability + ModelConstants.ScientistProbability + ModelConstants.HostProbability) {
                    people[r][c] = new Host();
                    peopleCollection.add(people[r][c]);
                    partyRoom.place(people[r][c], r, c);
                    people[r][c].setLocation(r, c);
                }
            }
        }
        view.setColor(Host.class, Color.BLACK);
        view.setColor(Artists.class, Color.LIGHT_GRAY);
        view.setColor(Scientist.class, Color.ORANGE);
        view.setColor(Engineer.class, Color.red);

    }

    
    
     public void run(){
        start();
        //thread is a seperate proccess
        //can synchronmise processes
    }

     //make every person in the peoplecollection arraylist act 
     //they act on a clone of the partyroom and once every person has acted the clone of the party room is given as the value of the party room
     //the simulation is displayed every time this method is called
    public void simulateOneStep() {
        Field clone = partyRoom.cloneField();
        for (int i = 0; i < peopleCollection.size(); i++) {
            (peopleCollection.get(i)).act(clone);
        }
        partyRoom = clone;
        view.showStatus(currentStep, partyRoom);

    }
    
    //runs the simulation for the number of steps according to user input
    //calls simulateOneStep to move people
    //increments currentStep by one
    public void simulate(int steps) {
        for (int i = 1; i < steps+1; i++) {
           // System.out.println(steps);
            simulateOneStep();
            currentStep++;
            //System.out.println(currentStep);
        }

    }
//starts the simulation by populating the party, showing the simulator view then calling the simulate method
    public void start() {
        populate();
        view.showStatus(currentStep, partyRoom);
        simulate(ModelConstants.NumberofSteps);
        
    }

    

}
