/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author richa
 */

package party;

import partyGivenClasses.Field; //Import classes from the partyGivenClass
import partyGivenClasses.SimulatorView;
import partyGivenClasses.RandomGenerator;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import javax.swing.*;



 
public class GUI {
    private static JFrame frame; //creates a frame for the GUI
    private static JPanel panel; //creates a panel
    private static JButton start; //creates button to start simulation
    private static JButton exit; //create button to closes simulation  
    private static JButton set; //set user input constants
   
   
    public static JTextField artistProb; //creates text field for the guest and host probability
    public static JTextField engineerProb;
    public static JTextField hostProb;
    public static JTextField scientistProb;
    public static JTextField seed;  //creates a text field for random generator field
    public static JTextField maxSteps; // creates a text field for the max steps
    public static JTextField sizeOfRoomHeight; //creates a text field for the size of the room width and height
    public static JTextField sizeOfRoomWidth;
    public static JTextField distWindow; //creates a distance guest can go
    
    public static JLabel artistLabel; //creates a label for the guest and host
    public static JLabel engineerLabel;
    public static JLabel hostLabel;
    public static JLabel scientistLabel;
    public static JLabel stepsLabel;//  creeats label for the steps
    public static JLabel seedLabel; //creates random generator label
    public static JLabel probLabel; //creates probability label
    public static JLabel sizeOfRoomLabel;
    public static JLabel distWindowLabel;

    public static Thread simThread; //creates a seed 
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        initialise();
    }
    
    public static void initialise() {
        //creates and initalises components
        frame = new JFrame("Party Simulation"); 
        panel = new JPanel(null);
        start = new JButton("START");
        start.setBounds(20,160,95,30); //sets coordinates and size of component 
        start.addActionListener(new ActionListener(){  
        @Override
        public void actionPerformed(ActionEvent e){  
              simThread = new Thread(new Simulator(ModelConstants.Width,ModelConstants.Height)); 
              simThread.start(); //once start button is clicked the simulation will start
        }  
        }); 
         
        exit = new JButton("EXIT");
        exit.setBounds(120,160,95,30);  
        exit.addActionListener(new ActionListener(){  
        @Override
        public void actionPerformed(ActionEvent e){  
              System.exit(0);   //once button is clicked program will close           
        }
        });
        
        set = new JButton("SET");
        set.setBounds(220,160,95,30);  
        set.addActionListener(new ActionListener(){  
        @Override
        public void actionPerformed(ActionEvent e){  
            ModelConstants.setConstants(); //calls on the setConstant method for model constants
             
        }
        });
            
        //creates and set location (bounds) for labels created
        seedLabel = new JLabel("GENERATOR SEED"); 
        seedLabel.setBounds(100,10,120,15);
        stepsLabel = new JLabel("MAX STEPS");
        stepsLabel.setBounds(220,10,100,15);
        distWindowLabel= new JLabel("DIST TRAVELLED");
        distWindowLabel.setBounds(300,10,100,15);
        sizeOfRoomLabel= new JLabel("SIZE OF ROOM");
        sizeOfRoomLabel.setBounds(400,10,100,15);
        
        hostLabel = new JLabel("HOST");
        hostLabel.setBounds(100,65,80,20);
        artistLabel = new JLabel("ARTIST");
        artistLabel.setBounds(220,65,80,20);
        engineerLabel = new JLabel("ENGINEER");
        engineerLabel.setBounds(300,65,80,20);
        scientistLabel = new JLabel("SCIENTIST");
        scientistLabel.setBounds(400,65,80,20);
        
        
        probLabel = new JLabel("PROB:");
        probLabel.setBounds(20,100,80,15);
       
        
        
        hostProb = new JTextField();
        hostProb.setBounds(100,95,40,20);
        artistProb = new JTextField();
        artistProb.setBounds(220,95,40,20);
        engineerProb = new JTextField();
        engineerProb.setBounds(300,95,40,20);
        scientistProb = new JTextField(); 
        scientistProb.setBounds(400,95,40,20);
        
      
        
        seed = new JTextField();
        seed.setBounds(100,35,40,20);
        
        maxSteps = new JTextField();
        maxSteps.setBounds(220,35,40,20);
        
        distWindow = new JTextField();
        distWindow.setBounds(300,35,40,20);
        
        sizeOfRoomHeight = new JTextField();
        sizeOfRoomHeight.setBounds(400,35,40,20);
        sizeOfRoomWidth= new JTextField();
        sizeOfRoomWidth.setBounds(450,35,40,20);
        
       
        
       
        probLabel.setBounds(20,100,80,15);
        
        
        
        frame.setSize(530,250); // sets size of JFrame
        frame.setVisible(true); 
        frame.setResizable(true);
        
        // addinng all components to the panel
        panel.add(start);
        panel.add(exit);
        panel.add(set);
        panel.add(artistProb);
        panel.add(hostProb);
        panel.add(engineerProb);
        panel.add(scientistProb);
        panel.add(seed);
        panel.add(maxSteps);
        panel.add(sizeOfRoomHeight);
        panel.add(sizeOfRoomWidth);
        panel.add(distWindow);
        panel.add(artistLabel);
        panel.add(hostLabel);
        panel.add(scientistLabel);
        panel.add(engineerLabel);
        panel.add(probLabel);
        panel.add(seedLabel);
        panel.add(sizeOfRoomLabel);
        panel.add(stepsLabel);
        panel.add(distWindowLabel);
        
        //adding panel to JFrame
        frame.add(panel);
    }
}
   




	


   
