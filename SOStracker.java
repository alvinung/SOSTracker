/* Alvin Ung */


import java.util.Scanner;


public class SOSTracker {

	/* Globals */
	static int ppLeft;
	static int encounters = 0;

	public static void main (String[] args) {

		/* Constructors */
		Scanner input = new Scanner(System.in);

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
					commands[0] == "ww" | commands[0] == "r") {
					processCommand(commands[0]);

				}
				else {
					System.out.println("Invalid Commands");
				}
			}
		}
	}

	void processCommand(String command) {
		// if (command == 'a') {
		// 	ppLeft--;
		// }
		// if (command == 'e') {
		// 	encounters++;
		// }
		// if (comma)
		if (command == null) {
			// error
		}
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
		}
	}

}