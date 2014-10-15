
import Classes.VoidWorld;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
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
    Boolean scavengerGL;
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
    int level;
    int xp;
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
    int earthZ1EnemyDrones;
    int earthEnemy;
    Boolean alert;
    int playerAttackRoll;
    Boolean fighterGL;
    int predatorSelected;
    int scavengerSelected;
    Boolean splashScreen;
    //Location
    String location = "A1";
    int earthMissionCount = 1;
    String playersystem;
    String playerPlanet;
    Boolean earthVisited;
    int mars;
    int fc;
    //Characters
    String cpName;
    //Objects

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
        predator = 3;
        playershipcount = 5;
        scavenger = 1;
        //Player
        level = 1;
        xp = 100;
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
        scavengerGL = false;
        splashScreen = true;
        earthZ1EnemyDrones = randomNumber(4);
        //Location
        playerPlanet = "earth";
        earthVisited = false;
        mars = 1;
        fc = 1;
        //Characters
        cpName = "CommandPal";

    }

    public void play() {
        //Game starts displays Logo and starter text.
        if (splashScreen == true) {
            splashScreen();
            splashScreen = false;
        }
//        actionMenu();
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
            } else if (input.equalsIgnoreCase("Test")) {
                VoidWorld world = new VoidWorld();
                
                world.getTest();
            } else {
                inputError();
            }
        }

    }

    private void selectMenu() {

        menuBar();

        System.out.println(ansiRed + "\n<Select Ship(s)>" + ansiNormal);
        if (level == 1) {
            System.out.println("1.Predator(s)");
            System.out.println("2.Scavenger(s)");
            System.out.println("3.Factory(s)");
        } else if (level == 2) {
            System.out.println(" More to follow.");
        }

        input = scanner.nextLine();
        if (input.equalsIgnoreCase("1") && predator > 0) {
            System.out.println(ansiRed + "\n<Predator(s) Selected>" + ansiNormal);

            System.out.println("1.Group-Link");
            System.out.println("2.Individual");

            input = scanner.nextLine();
            if (input.equalsIgnoreCase("1")) {
                clearScreen();
                commandPal();

                System.out.println(" Group-Link initiated....");
                fighterGL = true;

                if (fighterGL == true) {
                    predatorSelected = predator;
                    commandPal();
                    System.out.println(" " + predatorSelected + " x Predator(s) Selected\n");
                    pause1();

                    commandPal();
                    System.out.println(" Solution Ready..Firing.");
                    soundFiring();
                    soundFiring();
                    pause2();
                }
            } else if (input.equalsIgnoreCase("2")) {
                clearScreen();
                commandPal();
                predatorSelected = 1;
                System.out.println(" " + predatorSelected + " x Predator(s) Selected.");
                pause1();
                commandPal();
                System.out.println(" Solution Ready..Firing.");
                soundFiring();
                pause2();
            }
        } else if (input.equalsIgnoreCase("2")) {

            System.out.println(" Scavenger Selected...");

            System.out.println("1.Group-Link");
            System.out.println("2.Individual");

            input = scanner.nextLine();
            if (input.equalsIgnoreCase("1")) {
                clearScreen();
                commandPal();

                System.out.println(" Group-Link initiated....");
                scavengerGL = true;

                if (scavengerGL == true) {
                    scavengerSelected = scavenger;
                    commandPal();
                    System.out.println(" " + scavenger + " x Scavenger(s) Selected\n");
                    pause2();

                }
            }

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
        menuBar();
        commandPal();
        System.out.println(" System Error..Please Try again.");
        actionMenu();
    }

    public void scan() {
        if (playerPlanet.equalsIgnoreCase("Earth")) {
            clearScreen();
            menuBar();
            commandPal();
            System.out.println(" You have " + earthMissionCount + " mission(s) in this sector.");
            pause1();
            commandPal();
            System.out.println(" There are " + earthZ1EnemyDrones + " enemy(s) in range.");
        }

    }

    public void attackMenu() {
        soundTyping();

        menuBar();
        commandPal();
        System.out.println(" Scanning " + playerPlanet + " for targets...");
        pause1();
        commandPal();
        System.out.println(" Targets found...Loading target list.");
        pause1();

        menuBar();
        AnsiConsole.out().print(ansiRed + "<" + "Select Targets" + ">" + ansiNormal);
        if (playerPlanet.equalsIgnoreCase("earth")) {
            earthCombat();

        } else if (playerPlanet.equalsIgnoreCase("mars")) {
            System.out.println("\n1.Mars Enemies");
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

        menuBar();
        System.out.println("You now have " + predator + " Predator(s)");
        soundPredBuilt();
        System.out.println(ansiRed + "\n"
                + "  	    ||	\n"
                + "        \\--|OO|--/\n"
                + "    \\======/[]\\======/\n"
                + "<xxx------|----|------xxx>\n"
                + "    /======\\[]/======\\\n"
                + "       oO0Oo  oO0Oo\n"
                + "           \\--/\n" + ansiNormal);
        pause2();

    }

    private void buildMenu() {

        menuBar();
        if (factory > 0) {

            pause1();
            soundTyping();
            commandPal();
            System.out.println(" Link established...");
            commandPal();
            System.out.println(" Loading build options...");
            pause1();
            menuBar();
            if (level ==1){
                level1BuildOptions();
            }
            else if (level ==2){
                System.out.println("Display Level 2 options.");
            }
        }    
           else {
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

    private void zoneEarth() {
        earthZ1EnemyDrones = randomNumber(4);
        if (earthVisited == true) {

            menuBar();
            commandPal();
            AnsiConsole.out().println(ansiRed + " [Location: Earth]" + ansiNormal);

            earthVisited = false;
        } else {

            menuBar();
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

    private void menuBar() {
        clearScreen();
        System.out.println("*****************************************************");
        System.out.println(ansiRed + " Bio:" + bio + "  Elements:" + elements + "  Predators:" + predator + "  Scavengers:" + scavenger + ansiNormal);
        System.out.println("*****************************************************");
        System.out.println(ansiRed + " XP:" + xp + "  Level:" + level + ansiNormal);
        System.out.println("*****************************************************\n\n\n");
    }

    private void actionMenu() {
        soundTyping();
        menuBar();
        System.out.println(ansiRed + "<Action>" + ansiNormal);
        System.out.println("1.Scan");
        System.out.println("2.Firing Solution");
        System.out.println("3.Build");
        System.out.println("4.Select");
        System.out.println("5.Jump");
        System.out.println("6.Close Action Menu");
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
            play();
        }

    }

    public static int randomNumber(int max) {

        Random foo = new Random();
        int randomNumber = foo.nextInt(max);
        return randomNumber;
    }

    public void soundSplashScreen() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("Sounds/Martian_Death_Ray-Mike_Koenig-937891031.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

        } catch (Exception ex) {

        }
    }

    public void soundFiring() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("Sounds/Minigun-Jim_Rogers-633894726.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

        } catch (Exception ex) {

        }
    }

    public void soundPredBuilt() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("Sounds/UFO_Takeoff-Sonidor-1604321570.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

        } catch (Exception ex) {

        }
    }

    public void soundTyping() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("Sounds/Typing On Old Typewriter-SoundBible.com-673408176.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

        } catch (Exception ex) {

        }
    }

    public void soundCounterFire() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("Sounds/Grenade-SoundBible.com-2124844747.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

        } catch (Exception ex) {

        }
    }

    public void earthCombat() {
        System.out.println("\n1.Drone(s) x" + earthZ1EnemyDrones);
        input = scanner.nextLine();
        if (input.equalsIgnoreCase("1")) {
            selectMenu();
            playerAttackRoll = randomNumber(4);

            if (playerAttackRoll > 0) {
                soundTyping();
                commandPal();
                if (fighterGL == true) {
                    droneArmor = droneArmor - mainGun * predator;
                } else {
                    droneArmor = droneArmor - mainGun;
                }
                System.out.println(" Target has " + ansiRed + droneArmor + ansiNormal + " armor left.");
                pause2();
                if (droneArmor > 0) {

                    actionMenu();
                } else if (droneArmor <= 0) {
                    earthZ1EnemyDrones = earthZ1EnemyDrones - 1;
                    commandPal();
                    System.out.println(" Drone has been destroyed...");
                    pause1();
                    commandPal();
                    System.out.println(" You have gained " + ansiGreen + "20 XP" + ansiNormal );
                    pause3();
                    actionMenu();
                }

            } else {
                commandPal();
                System.out.println(" Target " + ansiRed + " Evaded." + ansiNormal);
                pause1();
                commandPal();
                System.out.println(" Target has " + ansiRed + droneArmor + ansiNormal + " armor left.");
                pause2();
                menuBar();
                commandPal();
                System.out.println(" Counter Fire Detected.");

                int counterFireRoll = randomNumber(3);
                if (counterFireRoll == 0) {

                    commandPal();
                    System.out.println(" Enemy Evaded.");
                    pause3();

                } else if (counterFireRoll == 1) {

                    commandPal();
                    soundCounterFire();
                    System.out.println(" Factory has been hit.");
                    pause3();
                } else if (counterFireRoll == 2) {

                    commandPal();
                    soundCounterFire();
                    System.out.println(" Predator has been hit.");
                    pause3();
                }
                actionMenu();
            }
        }
    }

    public void timerBuildPredator() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            public void run() {
                buildPredator();
            }
        }, 20 * 1000);
    }

    public void timerBuildFactory() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            public void run() {
                buildFactory();
            }
        }, 20 * 1000);
    }

    public void level1BuildOptions() {
            System.out.println("\n1.Predator " + "Bio:" + predatorCostBio + " Elements:" + predatorCostElement);
                System.out.println("2.Scavenger");
                System.out.println("3.Factory");
            
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("1")) {
                if (bio > predatorCostBio && elements > predatorCostElement) {

                    menuBar();
                    commandPal();
                    System.out.println(" Predator Queued.");
                    pause2();
                    timerBuildPredator();
                    actionMenu();

                } else {
                    System.out.println(" \nYou do not have enough resources..");
                }
            } else if (input.equalsIgnoreCase("2")) {

                System.out.println(" \nBuilding Scavenger...");
                buildScavenger();

            } else if (input.equalsIgnoreCase("3")) {

                System.out.println(" \nBuilding Factory...");
                timerBuildFactory();
            }
        }
    
    public void level2BuildOptions() {
            System.out.println("\n1.Predator " + "Bio:" + predatorCostBio + " Elements:" + predatorCostElement);
                System.out.println("2.Scavenger");
                System.out.println("3.Factory");
            
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("1")) {
                if (bio > predatorCostBio && elements > predatorCostElement) {

                    menuBar();
                    commandPal();
                    System.out.println(" Predator Queued.");
                    pause2();
                    timerBuildPredator();
                    actionMenu();

                } else {
                    System.out.println(" \nYou do not have enough resources..");
                }
            } else if (input.equalsIgnoreCase("2")) {

                System.out.println(" \nBuilding Scavenger...");
                buildScavenger();

            } else if (input.equalsIgnoreCase("3")) {

                System.out.println(" \nBuilding Factory...");
                timerBuildFactory();
            }
        } 
    
    public void level5BuildOptions() {
            System.out.println("\n1.Predator " + "Bio:" + predatorCostBio + " Elements:" + predatorCostElement);
                System.out.println("2.Scavenger");
                System.out.println("3.Factory");
            
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("1")) {
                if (bio > predatorCostBio && elements > predatorCostElement) {

                    menuBar();
                    commandPal();
                    System.out.println(" Predator Queued.");
                    pause2();
                    timerBuildPredator();
                    actionMenu();

                } else {
                    System.out.println(" \nYou do not have enough resources..");
                }
            } else if (input.equalsIgnoreCase("2")) {

                System.out.println(" \nBuilding Scavenger...");
                buildScavenger();

            } else if (input.equalsIgnoreCase("3")) {

                System.out.println(" \nBuilding Factory...");
                timerBuildFactory();
            }
        } 
    public void level8BuildOptions() {
            System.out.println("\n1.Predator " + "Bio:" + predatorCostBio + " Elements:" + predatorCostElement);
                System.out.println("2.Scavenger");
                System.out.println("3.Factory");
            
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("1")) {
                if (bio > predatorCostBio && elements > predatorCostElement) {

                    menuBar();
                    commandPal();
                    System.out.println(" Predator Queued.");
                    pause2();
                    timerBuildPredator();
                    actionMenu();

                } else {
                    System.out.println(" \nYou do not have enough resources..");
                }
            } else if (input.equalsIgnoreCase("2")) {

                System.out.println(" \nBuilding Scavenger...");
                buildScavenger();

            } else if (input.equalsIgnoreCase("3")) {

                System.out.println(" \nBuilding Factory...");
                timerBuildFactory();
            }
        } 
    
    public void level13BuildOptions() {
            System.out.println("\n1.Predator " + "Bio:" + predatorCostBio + " Elements:" + predatorCostElement);
                System.out.println("2.Scavenger");
                System.out.println("3.Factory");
            
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("1")) {
                if (bio > predatorCostBio && elements > predatorCostElement) {

                    menuBar();
                    commandPal();
                    System.out.println(" Predator Queued.");
                    pause2();
                    timerBuildPredator();
                    actionMenu();

                } else {
                    System.out.println(" \nYou do not have enough resources..");
                }
            } else if (input.equalsIgnoreCase("2")) {

                System.out.println(" \nBuilding Scavenger...");
                buildScavenger();

            } else if (input.equalsIgnoreCase("3")) {

                System.out.println(" \nBuilding Factory...");
                timerBuildFactory();
            }
        } 
    
    public void level15BuildOptions() {
            System.out.println("\n1.Predator " + "Bio:" + predatorCostBio + " Elements:" + predatorCostElement);
                System.out.println("2.Scavenger");
                System.out.println("3.Factory");
            
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("1")) {
                if (bio > predatorCostBio && elements > predatorCostElement) {

                    menuBar();
                    commandPal();
                    System.out.println(" Predator Queued.");
                    pause2();
                    timerBuildPredator();
                    actionMenu();

                } else {
                    System.out.println(" \nYou do not have enough resources..");
                }
            } else if (input.equalsIgnoreCase("2")) {

                System.out.println(" \nBuilding Scavenger...");
                buildScavenger();

            } else if (input.equalsIgnoreCase("3")) {

                System.out.println(" \nBuilding Factory...");
                timerBuildFactory();
            }
        } 
    public void level20BuildOptions() {
            System.out.println("\n1.Predator " + "Bio:" + predatorCostBio + " Elements:" + predatorCostElement);
                System.out.println("2.Scavenger");
                System.out.println("3.Factory");
            
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("1")) {
                if (bio > predatorCostBio && elements > predatorCostElement) {

                    menuBar();
                    commandPal();
                    System.out.println(" Predator Queued.");
                    pause2();
                    timerBuildPredator();
                    actionMenu();

                } else {
                    System.out.println(" \nYou do not have enough resources..");
                }
            } else if (input.equalsIgnoreCase("2")) {

                System.out.println(" \nBuilding Scavenger...");
                buildScavenger();

            } else if (input.equalsIgnoreCase("3")) {

                System.out.println(" \nBuilding Factory...");
                timerBuildFactory();
            }
        } 
    

}
