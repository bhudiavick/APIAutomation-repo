package POJO;

public class Contractors {
	
	private String firstName;
	private String lastName;
	private String contractFrom;
	private String contractTo;
	public Contractors(String firstName, String lastName, String contractFrom, String contractTo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.contractFrom = contractFrom;
		this.contractTo = contractTo;
	}
	
	
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
	public String getContractFrom() {
		return contractFrom;
	}
	public void setContractFrom(String contractFrom) {
		this.contractFrom = contractFrom;
	}
	public String getContractTo() {
		return contractTo;
	}
	public void setContractTo(String contractTo) {
		this.contractTo = contractTo;
	}
	
	

}
