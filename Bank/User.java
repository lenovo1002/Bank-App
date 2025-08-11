package Bank;

public class User {
	private final int acNo; 
	private String cName ;
	private String email ;
	private static String branch = "Indira Nagar" ;
	private long phone ;
	private double balance = 0 ;
	
	

	public User(int acNo, String cName, String email, long phone) {
		this.acNo = acNo;
		this.cName = cName;
		this.email = email;
		this.phone = phone;
	}

	
	@Override
	public String toString() {
		return "[acNo=" + acNo + ", cName=" + cName + ", email=" + email + ", phone=" + phone + ", Balance="+balance+", Branch="+branch+"]";
	}
	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAcNo() {
		return acNo;
	}
	
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}

}
