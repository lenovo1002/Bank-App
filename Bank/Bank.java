package Bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	private int acNo = 132 ;
	List <User> ll ;
	public Bank () {
		ll = new ArrayList<User>() ;
		ll.add(new User (123, "RutviRaj", "rajparsharam3011@gmail.com", 7030602280L));
		ll.add(new User (124, "PriyaSharma", "priya.sharma@example.com", 9876543210L));
		ll.add(new User (125, "AmitPatel", "amit.patel@example.com", 8765432109L));
		ll.add(new User (126, "SnehaGupta", "sneha.gupta@example.com", 7654321098L));
		ll.add(new User (127, "RahulSingh", "rahul.singh@example.com", 6543210987L));
		ll.add(new User (128, "AnjaliJain", "anjali.jain@example.com", 9988776655L));
		ll.add(new User (129, "VikramYadav", "vikram.yadav@example.com", 8877665544L));
		ll.add(new User (130, "KavitaRao", "kavita.rao@example.com", 7766554433L));
		ll.add(new User (131, "ArjunKumar", "arjun.kumar@example.com", 6655443322L));
		ll.add(new User (132, "NishaVerma", "nisha.verma@example.com", 9000111222L));
	}
	public void createAc(String cName , String emali , long phone ) {
		acNo += 1 ;
		ll.add(new User(acNo, cName, emali, phone)) ;
		System.out.println("Account created with Ac No : "+acNo);
		
	}

	public double  checkBalance (int acNo) {
		return getUser(acNo).getBalance() ;	
	}
	
	private User getUser (int acNo) {
		return ll.stream().filter(user -> user.getAcNo() == acNo).findFirst().orElseThrow(() -> new IllegalArgumentException("Account not found ! "));
	}
	
	public String depositMoney(int acNo , double amount) {
		User u = getUser(acNo);
				u.setBalance(u.getBalance() + amount);
		return "\n"+amount+" credited to your bank account.\nAvalable balance : "+u.getBalance()+"\n" ;
	}

	
	public String withdrawMoney(int acNo , double amount) {
		
		if (amount<=0) {
			return "Invalid amount" ;
		}
		
		User u = getUser(acNo);
		if (u.getBalance()< amount) {
			return "Insuffieicent balance ! " ;
		}
		u.setBalance(u.getBalance() - amount);
return "\n"+amount+" debited from your bank account.\nAvalable balance : "+u.getBalance()+"\n" ;
	}

	public String closeAc(int acNo) {
		User u = getUser(acNo) ;
		ll.remove(u) ;
		return "Account deleted ! " ;
	}
	 
	public String userInfo (int acNo) {
		User u = getUser(acNo) ;
		return u.toString() ;
				
	}
	

}
