package Bank;
import java.util.Scanner;
public class ConsoleUI {
	
	public static String ui () {
		Bank b1 = new Bank () ;
		while (true) {
			
			System.out.print("""
					++++++++++++++++++++                         ++++++++++++++++++++
					                    WELCOME TO BANK of 'JAVA'
					++++++++++++++++++++                         ++++++++++++++++++++ 
					1. Create an Account
					2. Check Balance
					3. Deposit Money
					4. Withdraw Money
					5. Delete your account
					6. Get User Details
					7. Exit
					Enter your choice : """);
			Scanner scn = new Scanner (System.in) ;
			String choice = scn.next() ;
			if (choice.matches("^[1-7]$"))
			{
				switch (choice) {
				case "1" -> {
					System.out.print("Enter your name : ");
					String cName = scn.nextLine() ;
					scn.next() ;
					System.out.print("Enter your mail : ");
					String email = scn.nextLine() ;
					scn.next() ;
					System.out.print("Enter your phone : ");
					long phone = scn.nextLong() ;
					b1.createAc(cName , email , phone );  
					
				}
				
				case "2" -> {
					System.out.print("Enter your account number : ");
					try {
						System.out.println(b1.checkBalance(scn.nextInt()));
					}
					catch (Exception e) {
						System.out.println("Account not found ! \n");
					}
				}
				
				case "3" -> {
					
					System.out.print("Enter your account number : ");
					int acNo = scn.nextInt() ;
					System.out.print("Enter amount to be added : ");
					double amount = scn.nextDouble() ;
					try {
						System.out.println(b1.depositMoney(acNo , amount));
					}
					catch (Exception e) {
						System.out.println("Account not found ! \n");
					}
				}
				
				case "4" -> {
					
					System.out.print("Enter your account number : ");
					int acNo = scn.nextInt() ;
					System.out.print("Enter amount to be debited : ");
					double amount = scn.nextDouble() ;
					try {
						System.out.println(b1.withdrawMoney(acNo , amount));
					}
					catch (Exception e) {
						System.out.println("Account not found ! \n");
					}
				}
				
				case "5" -> {
					
					System.out.print("Enter your account number : ");
					
					try {
						System.out.println(b1.closeAc(scn.nextInt()));
					}
					catch (Exception e) {
						System.out.println("Account not found ! \n");
					}
				}
				
				
				case "6" -> {
					System.out.print("Enter your account number : ");
					
					try {
						System.out.println(b1.userInfo(scn.nextInt()));
					}
					catch (Exception e) {
						System.out.println("Account not found ! \n");
					}
				}
				
				case "7" -> {
					System.out.println("Thank you ! ");
					System.exit(0);
				}
				
				
				
				
					
				}
				
			}
			else {
				System.out.println("Invalid Input ! ");
			}
			
		}
	}

}
