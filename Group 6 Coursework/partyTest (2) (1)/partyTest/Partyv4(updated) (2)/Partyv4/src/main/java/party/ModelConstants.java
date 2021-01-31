/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package party;

/**
 *
 * @author thanu
 */

//Sets all the constants that will be used in the simulation
public class ModelConstants {
    public static int Width = 50;
    public static int Height = 50;
    //size of the field
    public static double ArtistProbability = 15.0;
    public static double EngineerProbability =30.0;
    public static double HostProbability = 25.0;
     public static double ScientistProbability = 10;
    //the creation probability of each person       
     public static int NumberofSteps = 100000;
     //the number of steps the simulation should run for
     public static int Window = 5;
     //the maximum number of grid cells the guest can move away from it's current position
     public static int generatorSeed = 44;
static void setConstants() {
//takes the constants user has inputted and converts it into type of variable needed 
ArtistProbability = Double.parseDouble(GUI.artistProb.getText().trim()); 
EngineerProbability = Double.parseDouble(GUI.engineerProb.getText().trim()); 
HostProbability = Double.parseDouble(GUI.hostProb.getText().trim()); 
ScientistProbability = Double.parseDouble(GUI.scientistProb.getText().trim());

Width = Integer.parseInt(GUI.sizeOfRoomWidth.getText().trim());
Height = Integer.parseInt(GUI.sizeOfRoomHeight.getText().trim());

NumberofSteps = Integer.parseInt(GUI.maxSteps.getText().trim());
Window = Integer.parseInt(GUI.distWindow.getText().trim());

generatorSeed = Integer.parseInt(GUI.seed.getText().trim());


}
}

