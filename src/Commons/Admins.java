package Commons;

public class Admins extends Customer implements Users {
	public Admins(String firstName, String lastName, String username, String password, String address, String state, 
			int zip, String country, String email, String securityQ, String securityA, int SSN) {
		//constructors
		
		super(firstName, lastName, username, password, address, 
				state, zip, country, email, securityQ, securityA, SSN);
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
}


