import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import org.fusesource.jansi.AnsiConsole;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mondo Diaz
 */
public class Void {

    //Ships
    int factory;
    int predator;
    int enemyships = 2;
    int playershipcount;
    int scavenger;
    String fire;
    String upgrade;
    String move;
    int predatorCostElement;
    String enemyshiplocation1 = "G2";
    int enemyshiphp = 5;
    int predatorCostBio;
    int droneArmor;
    int mainGun;
    //Player   
    String playername;
    int playerhp;

    //Resource  
    int elements;
    int bio;
    //Environment 
    Scanner scanner;
    Scanner firescanner;
    String input;
    String previousgame;
    String ansiWhiteOnBlue = "\u001b[37;44m";
    String ansiWhiteOnGreen = "\u001b[37;42m";
    String ansiNormal = "\u001b[0m";
    String ansiRed = "\u001b[31m";
    String ansiBlue = "\u001b[34m";
    String ansiGreen = "\u001b[32m";
    String ansiCyan = "\u001b[36m";
    BufferedWriter bf;
    Boolean introMission;
    int earthZ1Intro2Enemy = 1;
    int earthEnemy;
    Boolean alert;
    int playerAttackRoll;
    Boolean fighterGL;
    int predatorSelected;
    //Location
    String location = "A1";
    int earthMissionCount = 1;
    String playersystem;
    String playerPlanet;
    Boolean earth;
    int mars;
    int fc;
    //Characters
    String cpName;
    //Objects
    VoidGUI gui = new VoidGUI();

    public static void main(String[] args) {

        Void game = new Void();
        AnsiConsole.systemInstall();

        game.play();

    }

    public Void() {
        //Ships
        factory = 1;
        mainGun = 20;
        droneArmor = 40;
        predator = 0;
        playershipcount = 5;
        //Player
        //Resources
        elements = 400;
        bio = 400;
        predatorCostBio = 100;
        predatorCostElement = 100;
        //Environment
        scanner = new Scanner(System.in);
        firescanner = new Scanner(System.in);
        introMission = true;
        alert = false;
        fighterGL = false;
        //Location
        playerPlanet = "earth";
        earth = true;
        mars = 1;
        fc = 1;
        //Characters
        cpName = "CommandPal";

    }

    public void play() {
        //Game starts displays Logo and starter text.
        splashScreen();
        MenuBar();
        

        while (enemyships > 0) {

            input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("locate")) {
                locate();
            } else if (input.equalsIgnoreCase("attack")) {
                attackMenu();
            } else if (input.equalsIgnoreCase("Exit")) {
                exit();
            } else if (input.equalsIgnoreCase("Save")) {
                saveGame();
            } else if (input.equalsIgnoreCase("load")) {
                loadGame();
            } else if (input.equalsIgnoreCase("Jump")) {
                jumpMenu();
            } else if (input.equalsIgnoreCase("scan")) {
                scan();
            } else if (input.equalsIgnoreCase("help")) {
                helpMenu();
            } else if (input.equalsIgnoreCase("build")) {
                buildMenu();
            } else if (input.equalsIgnoreCase("select")) {
                selectMenu();
            } else if (input.equalsIgnoreCase("action")) {
                actionMenu();
            } else {
                inputError();
            }

//            if (playerPlanet.equalsIgnoreCase("Earth")) {
//
//                earth();
//            }
//            if (playerPlanet.equalsIgnoreCase("Mars")) {
//                mars();
//            }
//            if (playerPlanet.equalsIgnoreCase("Fleet Command")) {
//                fleetCommand();
//            }

        }

    }

    private void selectMenu() {
        String selectInput;

        MenuBar();

        System.out.println(ansiRed + "\n<Select Ship(s)>" + ansiNormal);

        System.out.println("1.Predator(s)");
        System.out.println("2.Scavenger(s)");
        System.out.println("3.Factory(s)");

        selectInput = scanner.nextLine();
        if (selectInput.equalsIgnoreCase("1") && predator > 0) {
            System.out.println("\nPredator(s) Selected...");
             soundPrompt();
            System.out.println("1.Group-Link");
            System.out.println("2.Individual");

            scanner.nextLine();
            if (selectInput.equalsIgnoreCase("1")) {
                 soundPrompt();
                System.out.println(" Group-Link initiated....");
                fighterGL = true;
                
                if (fighterGL == true){
                    predatorSelected = predator;
                    System.out.println(predator + " x Predator(s) Selected\n");
                    commandPal();
                    System.out.println(" Solution Ready..Firing.");
                    soundFiring();
                    pause2();
                }
            }
        } else if (input.equalsIgnoreCase("2")) {

            System.out.println(" Scavenger Selected...");

        } else if (input.equalsIgnoreCase("3")) {

            System.out.println(" Factory Selected...");

        }

    }

    public void buildFactory() {
        System.out.println("Factory built");
        factory++;
        System.out.println("You now have " + factory + " Factory(s)");
    }

    public void buildScavenger() {
        System.out.println("Scavenger built");
        scavenger++;
        System.out.println("You now have " + scavenger + " Scavenger(s)");
    }

    public void locate() {
        System.out.println("\nProcessing.....");
        System.out.println("..............................");
        System.out.println(playername + " is located at " + playerPlanet);
        System.out.println("..............................");
        System.out.println("Ready....");

    }

    public void exit() {
        System.out.println("\nNow exiting game.....\n");
        System.exit(0);
    }

    public void inputError() {
        clearScreen();
        MenuBar();
        commandPal();
        System.out.println(" System Error..Please Try again.");

    }

    public void scan() {
        if (playerPlanet.equalsIgnoreCase("Earth")) {
            clearScreen();
            MenuBar();
            commandPal();
            System.out.println(" You have " + earthMissionCount + " mission(s) in this sector.");
            pause1();
            commandPal();
            System.out.println(" There are " + earthZ1Intro2Enemy + " enemy(s) in range.");
        }

    }

    public void attackMenu() {
        soundTyping();
        clearScreen();
        MenuBar();
        commandPal();
        System.out.println(" Scanning " + playerPlanet + " for targets...");
        pause1();
        commandPal();
        System.out.println(" Targets found...Loading target list.");
        pause1();
        clearScreen();
        MenuBar();
        AnsiConsole.out().print(ansiRed + "<" + "Select Targets" + ">" + ansiNormal);
        if (playerPlanet.equalsIgnoreCase("earth")) {
            System.out.println("\n1.Drone(s) x" + earthZ1Intro2Enemy);
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("1")) {
                selectMenu();
                playerAttackRoll = randomNumber(4);

                if (playerAttackRoll > 0) {
                    System.out.println("Hit!");
                    droneArmor = droneArmor - mainGun;
                    System.out.println(" Target has " + droneArmor + " armor left.");

                    if (droneArmor > 0) {
                        System.out.println(" Drone has " + droneArmor + " armor left");
                        System.out.println(" What is your next action");
                    } else if (droneArmor <= 0) {
                        earthZ1Intro2Enemy = earthZ1Intro2Enemy - 1;
                        System.out.println(" Drone has been destroyed...");
                    }

                }
            }
        } else if (playerPlanet.equalsIgnoreCase("mars")) {
            System.out.println("\n1.Mars Enemies");
        }

        if (input.equalsIgnoreCase("1")) {

        } else {

            inputError();

        }
    }

    private void jumpMenu() {
        System.out.println("\nLoading Jump List...");
        System.out.println("....SOL System....");
        System.out.println("1.Earth");
        System.out.println("2.Mars");
        System.out.println("3.Fleet Command");
        String linput = scanner.nextLine();
        if (linput.equalsIgnoreCase("1")) {
            playerPlanet = "Earth";

        } else if (linput.equals("2")) {
            playerPlanet = "Mars";
            mars = 1;
        } else if (linput.equals("3")) {
            playerPlanet = "Fleet Command";
            fc = 1;
        }

        System.out.println("\nPreparing to Jump......");
        System.out.println("\nJumping.....");
        System.out.println("\nJump Complete.");
        System.out.println("\nArrived at " + playerPlanet);
        System.out.println("\nReady....");

    }

    private void saveGame() {
        try {
            System.out.println("Saving............");
            File f = new File(playername + ".txt");
            FileWriter fw = new FileWriter(playername + ".txt", true);
            bf = new BufferedWriter(fw);
            bf.write("1");
            bf.newLine();
            bf.write(playername);
            bf.newLine();
            bf.write(location);
            bf.newLine();
            bf.write(playershipcount);
            bf.newLine();
            bf.write(playerhp);
            bf.newLine();

            bf.newLine();

            bf.close();
            System.out.println("Ready....");
            System.out.printf(">");
        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    private void loadGame() {
        System.out.println("Loading previous game.....");
        try {
            FileReader fr = new FileReader(playername + ".txt");
            BufferedReader br = new BufferedReader(fr);

            previousgame = br.readLine();
            playername = br.readLine();
            location = br.readLine();

            br.close();
            System.out.println("Ready....");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void buildPredator() {
        
        System.out.println("Predator Built.");
        predator++;
        bio = bio - predatorCostBio;
        elements = elements - predatorCostElement;
        clearScreen();
        MenuBar();
        System.out.println("You now have " + predator + " Predator(s)");
        soundPredBuilt();
        System.out.println("\n"
                + "  	    ||	\n"
                + "        \\--|OO|--/\n"
                + "    \\======/[]\\======/\n"
                + "<xxx------|----|------xxx>\n"
                + "    /======\\[]/======\\\n"
                + "       oO0Oo  oO0Oo\n"
                + "           \\--/\n");
        pause2();

    }

    private void buildMenu() {
        
        clearScreen();
        
        MenuBar();
        if (factory > 0) {

            pause1();
            soundTyping();
            commandPal();

            System.out.println(" Link established...");
           
            pause1();
            commandPal();
            System.out.println(" Loading build options...");
            pause1();
            clearScreen();
            MenuBar();

            System.out.println("\n1.Predator " + "Bio:" + predatorCostBio + " Elements:" + predatorCostElement);
            System.out.println("2.Scavenger");
            System.out.println("3.Factory");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("1")) {
                if (bio > predatorCostBio && elements > predatorCostElement) {
                    clearScreen();
                    MenuBar();

                    System.out.println("Building Predator...");
                    buildPredator();

                } else {

                    System.out.println(" \nYou do not have enough resources..");

                }
            } else if (input.equalsIgnoreCase("2")) {

                System.out.println(" \nBuilding Scavenger...");
                buildScavenger();

            } else if (input.equalsIgnoreCase("3")) {

                System.out.println(" \nBuilding Factory...");
                buildFactory();

            }
        } else {

            System.out.println(" \nFactory not Online...");

        }

    }

    private void splashScreen() {
        clearScreen();
        soundSplashScreen();
        System.out.println(ansiRed + "____   ____    .__    .___\n"
                + "\\   \\ /   /___ |__| __| _/\n"
                + " \\   Y   /  _ \\|  |/ __ | \n"
                + "  \\     (  <_> )  / /_/ | \n"
                + "   \\___/ \\____/|__\\____ | \n"
                + "                       \\/ " + ansiNormal);

        System.out.println("Pre-Alpha" + "\n\n");
        pause2();
        soundTyping();
        System.out.println("Systems initiating...");
        pause1();
        soundTyping();
        System.out.println("Ready.");
        pause1();
        soundTyping();
        System.out.println("Connecting to Fleet Command...");
        pause1();
        System.out.println("Link Established.");
        pause1();
        soundTyping();
        System.out.println("Activating CommandPal...");
        pause2();
        
        System.out.println("CommandPal Active.");
        
    }

    private void helpMenu() {

        System.out.println("\n............................");
        System.out.println("<Load>");
        System.out.println("<Save>");
        System.out.println("<Fire>");
        System.out.println("<Jump>");
        System.out.println("<Locate>");
        System.out.println("<Channel> (Not Ready)");
        System.out.println("<Exit>");
        System.out.println("<Scan> (Not Ready)");
        System.out.println("............................\n\n");

    }

    private void earth() {
        if (earth == true) {

            clearScreen();
            MenuBar();
            commandPal();
            AnsiConsole.out().println(ansiRed + " [Location: Earth]" + ansiNormal);
            
            earth = false;
        } else {
            clearScreen();
            MenuBar();
            commandPal();
            System.out.println(" Welcome back to Earth.");
        }
    }

    private void mars() {
        if (mars == 1) {
            System.out.println("\nScanning region.....Scan Complete.");

            System.out.println(".....Mars......");

            System.out.println(earthMissionCount + " missions are available\n\n");

            mars = 0;
        }
    }

    private void fleetCommand() {
        if (fc == 1) {
            System.out.println("\nScanning region.....Scan Complete.");

            System.out.println(".....Fleet Command......");

            System.out.println(earthMissionCount + " missions are available\n\n");

            fc = 0;
        }
    }

    private void clearScreen() {
        System.out.print("\u001b[2J");
        System.out.flush();
    }

    private void commandPal() {
        AnsiConsole.out().print(ansiCyan + "<" + cpName + ">" + ansiNormal);
    }

    private void pause1() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Void.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pause2() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Void.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pause3() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Void.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pause4() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Void.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pause5() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Void.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void renameCP() {
        System.out.println(" Please input new Designation");
        cpName = scanner.nextLine();
    }

    private void MenuBar() {
        System.out.println("*****************************************************");
        System.out.println(ansiRed + " Bio:" + bio + "  Elements:" + elements + "  Predators:" + predator + "  Scavengers:" + scavenger + ansiNormal);
        System.out.println("*****************************************************\n\n\n");
        
    }

    private void actionMenu() {
        soundTyping();
        clearScreen();
        MenuBar();
        
        System.out.println(ansiRed + "<Action>" + ansiNormal);
        System.out.println("1.Scan");
        System.out.println("2.Attack Solution");
        System.out.println("3.Build");
        System.out.println("4.Select");
        System.out.println("5.Jump");
        System.out.println("6.Help");
        input = scanner.nextLine();
        if (input.equalsIgnoreCase("1")) {
            scan();
        } else if (input.equalsIgnoreCase("2")) {
            attackMenu();
        } else if (input.equalsIgnoreCase("3")) {
            buildMenu();
        } else if (input.equalsIgnoreCase("4")) {
            selectMenu();
        } else if (input.equalsIgnoreCase("5")) {
            jumpMenu();
        } else if (input.equalsIgnoreCase("6")) {
            helpMenu();
        }

    }

    public static int randomNumber(int max) {

        Random foo = new Random();
        int randomNumber = foo.nextInt(max);
        return randomNumber;
    }

    public void soundSplashScreen() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./src/Sounds/Martian_Death_Ray-Mike_Koenig-937891031.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

        } catch (Exception ex) {

        }
    }
    
    public void soundFiring() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./src/Sounds/Minigun-Jim_Rogers-633894726.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

        } catch (Exception ex) {

        }
    }
    
    public void soundPrompt() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./src/Sounds/Blop-Mark_DiAngelo-79054334.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

        } catch (Exception ex) {

        }
    }
    
    public void soundPredBuilt() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./src/Sounds/UFO_Takeoff-Sonidor-1604321570.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

        } catch (Exception ex) {

        }
    }
    
    public void soundTyping() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./src/Sounds/Typing On Old Typewriter-SoundBible.com-673408176.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

        } catch (Exception ex) {

        }
    }
}
