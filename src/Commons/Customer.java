package Commons;

public class Customer implements Users {
	protected String firstName;
	protected String lastName;
	protected static String username;
	protected String password;
	protected String address;
	protected String state;
	protected int zip;
	protected String country;
	protected String email;
	protected String securityQ;
	protected String securityA;
	protected int ssn;
	//constructors for customers and then for admins
	public Customer(String firstName, String lastName, String username, String password, String address, String state, 
			int zip, String country, String email, String securityQ, String securityA, int SSN) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.address = address;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.email = email;
		this.securityQ = securityQ;
		this.securityA = securityA;
		this.ssn = SSN;	
	}
	
	//get and set everything
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public static String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String Address) {
		this.address = Address;
	}
	
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}
	
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getSecurityQ() {
		return securityQ;
	}
	public void setSecurityQ(String securityQ) {
		this.securityQ = securityQ;
	}
	
	
	public String getSecurityA() {
		return securityA;
	}
	public void setSecurityA(String securityA) {
		this.securityA = securityA;
	}
	
	
	public int getSSN() {
		return ssn;
	}
	public void setSSN(int ssn) {
		this.ssn = ssn;
	}
	
}
