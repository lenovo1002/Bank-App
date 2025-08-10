package Notes_App;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner; 
public class Notes {
	private static int i = 1 ;
	Scanner scn ; 
	public String writeNewNotes(String note) {
		String fileName =  "Note"+FileName()+"_"+dateTime();
		try {
		
		BufferedWriter bw =  new BufferedWriter(new FileWriter("D:\\Java\\Eclipse 2.0\\Elevate_Labs\\src\\Notes_App\\Files\\"+fileName+".txt" , true)) ;
		bw.write(note);
		bw.newLine();
		bw.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong ! ");
		}
		
		return fileName ;
	}
	
	public void editNote() throws IOException {
		scn = new Scanner (System.in) ;
		String basePath = "D:\\Java\\Eclipse 2.0\\Elevate_Labs\\src\\Notes_App\\Files\\" ;
	    File directory = new File(basePath);
	    String[] notes = directory.list((dir, name) -> name.endsWith(".txt") && !name.equals("imp.txt"));

	    if (notes == null || notes.length == 0) {
	        System.out.println("No notes found to edit.");
	        return;
	    }

	    System.out.println("\nAvailable Notes:");
	    for (int i = 0; i < notes.length; i++) {
	        System.out.println((i + 1) + ". " + notes[i]);
	    }

	    System.out.print("Enter the note number to edit: ");
	    int choice = scn.nextInt();
	    scn.nextLine();

	    if (choice < 1 || choice > notes.length) {
	        System.out.println("Invalid choice.");
	        return;
	    }

	    File selectedFile = new File(basePath + notes[choice - 1]);

	    System.out.println("\nCurrent Content:");
	    try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
	        String line;
	        while ((line = br.readLine()) != null) {
	            System.out.println(line);
	        }
	    }

	    System.out.println("\nEnter new content for the note (type 'END' on a new line to save):");
	    StringBuilder newContent = new StringBuilder();
	    String input;
	    while (!(input = scn.nextLine()).equalsIgnoreCase("END")) {
	        newContent.append(input).append("\n");
	    }

	    try (BufferedWriter bw = new BufferedWriter(new FileWriter(selectedFile, false))) {
	        bw.write(newContent.toString());
	    }

	    System.out.println("Note updated successfully!");
	}

	
	public void viewNote(int n ) {
		int limit = 0;
		try {
		BufferedReader br1 = new BufferedReader(new FileReader("D:\\Java\\Eclipse 2.0\\Elevate_Labs\\src\\Notes_App\\Files\\Hazard\\imp.txt")) ; 
		 limit = Integer.parseInt(br1.readLine()) ;
		br1.close(); }
		
		catch (Exception e) {
			System.out.println("error ! ");
		}
		if (limit ==0) {
			System.out.println("Nothing to see ! ");
			return ;
		}
		while (true) {
		System.out.println("Following files are present : ");
		
		File dir = new File("D:\\Java\\Eclipse 2.0\\Elevate_Labs\\src\\Notes_App\\Files") ;
		String [] arr = dir.list((d, name )-> name.endsWith(".txt")) ;
		for (int k = 1 ; k <=arr.length ; k++) {
			System.out.println(k+". "+arr[k-1]);
		}
		System.out.println("Enter your choice : ");
		scn = new Scanner (System.in) ;
		String choice = scn.next() ;
		String pattern = "^[1-"+limit+"]$";
		
		if (choice.matches(pattern)) {
			try {
			BufferedReader br = new BufferedReader(new FileReader("D:\\Java\\Eclipse 2.0\\Elevate_Labs\\src\\Notes_App\\Files\\"+arr[Integer.parseInt(choice)-1])) ;
			System.out.println();
			String line ; 
			while ((line = br.readLine())!=null) {
			System.out.println(line);}
			System.out.println();
			br.close();
			
		}
			catch (Exception e) {
				System.out.println("Something went wrong ! ");
				e.printStackTrace();
			}
			break ;
			
			}
		else {
			System.out.println("Invalid Input ! ");
		}
		
		
		}
		
	}
	
	private int FileName () {
		try {
		BufferedReader br1 = new BufferedReader(new FileReader("D:\\Java\\Eclipse 2.0\\Elevate_Labs\\src\\Notes_App\\Files\\Hazard\\imp.txt")) ; 
		i = Integer.parseInt(br1.readLine()) ;
		br1.close();
		BufferedWriter bw1 = new BufferedWriter(new FileWriter("D:\\Java\\Eclipse 2.0\\Elevate_Labs\\src\\Notes_App\\Files\\Hazard\\imp.txt")) ; 
		bw1.write((i+1)+"");
		bw1.newLine();
		bw1.close();
		
		}
		
		catch (Exception e) {
			System.out.println("Something went wrong ! ");
			e.printStackTrace();
		}
		
		return i ;
		
	}
	
	private String dateTime() {
		LocalDateTime ldt = LocalDateTime.now() ;
		DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss") ;
		return ldt.format(f1) ;
	}
	
	
	
	
	

}
