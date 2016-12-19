/* Alvin Ung */


import java.util.Scanner;


public class SOStracker {

	/* Globals */
	static int ppLeft;
	static int encounters = 0;

	public static void main (String[] args) {

		/* Constructors */
		Scanner input = new Scanner(System.in);

		/* Locals */
		boolean found = false;
		int result = 0;

		/* Select Pokemon to chain */
		String pokemon = input.nextLine();
		if (pokemon != null) {
			found = initPoke(pokemon);
			if (found == false) {
				System.out.println("\nError: Pokemon not found.");
			}
		}

		/* Program Loop */
		while (true) {
			System.out.print("Enter Tracking Information: ");
			String line = input.nextLine();
			String[] commands = line.trim().split("\\s+");

			if (commands.length > 2) {
				System.out.println("Invalid number of commands");
			}
			else {
				/* Loop through commands */
				if (commands[0] == "q" | commands[0] == "w" | commands[0] == "qq" | 
					commands[0] == "ww" | commands[0] == "r" | commands[0] == "exit") {
					result = processCommand(commands[0]);
					if (result == -1) {
						break;
					}
				}
				else if (commands[1] == "q" | commands[1] == "w" | commands[1] == "qq" | 
					commands[1] == "ww" | commands[1] == "r" | commands[1] == "exit") {
					result = processCommand(commands[0]);
					if (result == -1) {
						break;
					}
				}
				else {
					System.out.println("Invalid Commands");
				}
			}
			printStats();
		}
	}

	public static boolean initPoke(String pokemon) {
		switch(pokemon) {
			case "ditto":
				loadDitto();
				return true;
			default:
				System.out.println("Error: Pokemon not found.");
				return false;
		}
	}

	public static void printStats() {
		System.out.println("\nEncounter : " + encounters + "\n");
		System.out.println("Opponent PP Left : " + ppLeft + "\n");
	}

	public static int processCommand(String command) {

		switch(command) {
			case "q":
				ppLeft--;
				break;
			case "w":
				encounters++;
				break;
			case "qq":
				if (ppLeft > 0) {
					ppLeft--;
				}
				break;
			case "ww":
				if (encounters > 0) {
					encounters--;
				}
				break;
			case "r":
				// resets oponent pp
				break;
			case "exit":
				return -1;
			default:
				break;
		}
		return 0;
	}

	public static void loadDitto() {
		ppLeft = 20;
	}

}