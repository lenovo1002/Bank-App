package Notes_App;
import java.util.Scanner; 
public class ConsoleUI {
	public static void run () {
		Notes n1 = new Notes() ;
		Scanner scn = new Scanner (System.in) ;
		while (true) {
			System.out.println("""
					======================== Welcome to Notes App ========================
					1. View Notes
					2. Add New Note
					3. Edit Note
					4. Exit
					Enter you choice :	""");
			String choice = scn.next();
			scn.nextLine() ;
			if (choice.matches("^[1-4]$")) {
			switch (choice) {
			case "1" -> {n1.viewNote(2);}
			case "2" -> {
				System.out.println("Start writing your note ! : ");
				String note = scn.nextLine() ;
				System.out.println("File Saved as "+n1.writeNewNotes(note)+".txt");
				
				}
			case "3" -> { try {
				n1.editNote(); }
			catch (Exception e ) {
				System.out.println("Something went wrong ! ");
				e.printStackTrace();
			}
				}
			case "4" -> {System.out.println("Thank you for using our application ! ");
							System.exit(0);}		
			}
		}
			else {
				System.out.println("Invalid Input ! ");
			}
		
		}
		
	}}

