package Commons;

public class Admins extends Customer{
	public Admins(String firstName, String lastName, String username, String password, String address, String state, 
			int zip, String country, String email, String securityQ1, String securityA1, String securityQ2, String securityA2, int SSN) {
		//constructors
		
		super(firstName, lastName, username, password, address, 
				state, zip, country, email, securityQ1, securityA1, securityQ2, securityA2, SSN);
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
}


