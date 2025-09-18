import java.util.Scanner;

public class GetNameConsole {
	
	public static void main (String[] args) {
		
		System.out.print("Enter your name: ");
		
//		i guess we are CREATING a scanner  object --> so that LATER we can consume shifting the input into the object
		Scanner in = new Scanner(System.in);

//		– nextLine() blocks the program until the user types characters and presses Enter.
//		– It consumes everything up to that newline (including spaces), converts the bytes to a String, and returns it.
//		– The resulting string is assigned to the reference variable <name>, ready for later use (e.g., printing a greeting).

		String name = in.nextLine();
		
		
		System.out.println("Hello " + name + "!");
		
		in.close();
		
		
	} 
}