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
	protected String securityQ1;
	protected String securityA1;
	protected String securityQ2;
	protected String securityA2;
	protected int ssn;
	//constructors for customers and then for admins
	public Customer(String firstName, String lastName, String username, String password, String address, String state, 
			int zip, String country, String email, String securityQ1, String securityA1, String securityQ2, String securityA2,int SSN) {
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
		this.securityQ1 = securityQ1;
		this.securityA1 = securityA1;
		this.securityQ2 = securityQ2;
		this.securityA2 = securityA2;
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
	
	
	public String getSecurityQ1() {
		return securityQ1;
	}
	public void setSecurityQ1(String securityQ1) {
		this.securityQ1 = securityQ1;
	}
	
	
	public String getSecurityA1() {
		return securityA1;
	}
	public void setSecurityA1(String securityA1) {
		this.securityA1 = securityA1;
	}
	
	public String getSecurityQ2() {
		return securityQ2;
	}
	public void setSecurityQ2(String securityQ2) {
		this.securityQ2 = securityQ2;
	}
	
	
	public String getSecurityA2() {
		return securityA2;
	}
	public void setSecurityA2(String securityA2) {
		this.securityA2 = securityA2;
	}
	public int getSSN() {
		return ssn;
	}
	public void setSSN(int ssn) {
		this.ssn = ssn;
	}
	
}
