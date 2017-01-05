/* Alvin Ung */


import java.util.Scanner;


public class SOStracker {

	/* Globals */
	static int ppLeft;
	static int encounters = 0;
	static int resetVal;
	static String pokemon;

	public static void main (String[] args) {

		/* Constructors */
		Scanner input = new Scanner(System.in);

		/* Locals */
		boolean valid = false;
		boolean found = false;
		boolean print = false;
		boolean loop = true;
		int result = 0;

		/* Select Pokemon to chain */
		clearScreen();
		System.out.println("Welcome\n");

		while (valid == false) {
			if (print == true) {
				System.out.println("Error: Pokemon not found.\n");
				print = false;
			}
			System.out.println("Available Pokemon : [ Beldum, Ditto , Zubat ]");
			System.out.print("Select a Pokemon to chain: ");

			String pokemon = input.nextLine();
			if (pokemon != null) {
				if (pokemon.equals("exit")) {
					break;
				}
				found = initPoke(pokemon);
				if (found == true) {
					printStats();
					valid = true;
					clearScreen();
				}
				else {
					clearScreen();
					print = true;
				}
			}
		}

		System.out.println("Currently chaining " + pokemon);
		System.out.println("*******************************");
		printStats();

		/* Program Loop */
		while (loop == true && valid == true) {
			System.out.println("*******************************\n");
			printCommands();
			System.out.print("Enter Tracking Commands: ");
			String line = input.nextLine();
			String[] commands = line.trim().split("\\s+");
			clearScreen();

			/* Processing Commands */
			if (commands.length > 2) {
				System.out.println("Invalid number of commands\n");
			}
			else {
				for (int i = 0; i < commands.length; i++) {
					if (commands[i].equals("q") | commands[i].equals("w") | commands[i].equals("qq") | 
							commands[i].equals("ww") | commands[i].equals("r") | commands[i].equals("exit")) {
						result = processCommand(commands[i]);
						if (result == -1) {
							loop = false;
						}
					}
					else {
						System.out.println("Invalid Commands\n");
					}
				}
			}
			System.out.println("Currently chaining " + pokemon);
			System.out.println("*******************************");
			printStats();
		}
		System.out.println("******* Exiting Program *******");
	}

	public static void printCommands() {
		System.out.println("Valid Commands\n");
		System.out.println("	Increment Encounter Count : [q]");
		System.out.println("	Decrement Encounter Count : [qq]");
		System.out.println("	Increment Opponent PP Count : [w]");
		System.out.println("	Decrement Opponent PP Count : [ww]");
		System.out.println("	Reset PP Count for new encounter : [r]");
		System.out.println("	Terminate Program : [exit]\n");
	}

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static boolean initPoke(String pokemon) {
		switch(pokemon.toLowerCase()) {
			case "ditto":
				loadDitto();
				return true;
			case "beldum":
				loadBeldum();
				return true;
			case "zubat":
				loadZubat();
				return true;
			default:
				return false;
		}
	}

	public static void printStats() {
		System.out.println("\nEncounter : " + encounters + "\n");
		System.out.println("Opponent PP Left : " + ppLeft + "\n");
	}

	public static int processCommand(String command) {

		switch(command) {
			case "w":
				ppLeft--;
				break;
			case "q":
				encounters++;
				break;
			case "ww":
				if (ppLeft > 0 && ppLeft < resetVal) {
					ppLeft++;
				}
				else {
					System.out.println("PP count cannot go any higher!\n");
				}
				break;
			case "qq":
				if (encounters > 0) {
					encounters--;
				}
				else {
					System.out.println("Encounter count cannot go any lower!\n");
				}
				break;
			case "r":
				ppLeft = resetVal;
				System.out.println("Resetting Opponent's PP...\n");
				break;
			case "exit":
				return -1;
			default:
				break;
		}
		return 0;
	}

	/* Pokemon Profiles */

	public static void loadDitto() {
		ppLeft = 20;
		resetVal = 20;
		pokemon = "Ditto";
	}

	public static void loadBeldum() {
		ppLeft = 20;
		resetVal = 20;
		pokemon = "Beldum";
	}

	public static void loadZubat() {
		ppLeft = 85;
		resetVal = 85;
		pokemon = "Zubat";
	}

}