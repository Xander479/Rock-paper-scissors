import java.util.Random;
import java.util.Scanner;
public class Janken {
	public static void main(String[] args) throws Exception {
		String[] options = {"R", "P", "S"};
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		boolean newGame = false;
		do {
			System.out.print("Do you choose rock, paper, or scissors? [R/P/S]  ");
			String myChoice = s.next();
			// Makes sure you enter a valid choice
			boolean loop = true;
			while(loop) {
				for(String str : options) {
					if(str.equals(myChoice.toUpperCase())) loop = false;
				}
				if(loop) {
					s.nextLine();
					System.out.print("Please choose a valid option. [R/P/S]  ");
					myChoice = s.next();
				}
			}
			myChoice = myChoice.toUpperCase();
			// Makes the cpu choose randomly
			String cpuChoice = options[r.nextInt(3)];
			System.out.println();
			/* First array = player rock
			 * Second array = player paper
			 * Third array = player scissors
			 * Items within arrays = cpu rock, paper, scissors
			 */
			int[][] outcomes = {{0, 1, 2}, {2, 0, 1}, {1, 2, 0}};
			System.out.println("You chose " + myChoice + " and the CPU chose " + cpuChoice + ".");
			switch(outcomes[choiceToInt(myChoice)][choiceToInt(cpuChoice)]) {
				case 0:
					System.out.println("It's a tie!");
					break;
				case 1:
					System.out.println("You lose!");
					break;
				case 2:
					System.out.println("You win!");
				default:
					System.out.println("Please email contact@xander479.co.uk and tell me exactly what you input to see this message.");
			}
			System.out.println();
			System.out.print("Would you like to play again? [Y/N]  ");
			myChoice = s.next();
			loop = true;
			switch(myChoice.toLowerCase()) {
				case "y":
					System.out.println("Great, enjoy!");
					System.out.println();
					newGame = true;
					break;
				case "n":
					System.out.println("Okay, goodbye!");
					break;
				default:
					System.out.println("I'll just take that as a no...");
			}
		} while(newGame);
	}
	
	// I fucked up and this is my hot fix
	static int choiceToInt(String choice) throws Exception {
		switch(choice) {
			case "R":
				return 0;
			case "P":
				return 1;
			case "S":
				return 2;
			default:
				throw new Exception("I don't know how you did this");
		}
	}
}
