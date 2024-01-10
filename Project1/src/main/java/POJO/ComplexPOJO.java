package POJO;

import java.util.List;

public class ComplexPOJO {
	private String companyName;
    private String cityName;
    private String companyCEO;
    private List<String> bankListForSalary;
    private List<Integer> pincodesOfCityOffice;
     List<SamplePOJO> employees;
     List<Contractors> contractors;
     CompanyPFDetails companyPFDetails;
	public ComplexPOJO(String companyName, String cityName, String companyCEO, List<String> bankListForSalary,
			List<Integer> pincodesOfCityOffice, List<SamplePOJO> employees, List<Contractors> contractors,
			CompanyPFDetails companyPFDetails) {
		super();
		this.companyName = companyName;
		this.cityName = cityName;
		this.companyCEO = companyCEO;
		this.bankListForSalary = bankListForSalary;
		this.pincodesOfCityOffice = pincodesOfCityOffice;
		this.employees = employees;
		this.contractors = contractors;
		this.companyPFDetails = companyPFDetails;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCompanyCEO() {
		return companyCEO;
	}
	public void setCompanyCEO(String companyCEO) {
		this.companyCEO = companyCEO;
	}
	public List<String> getBankListForSalary() {
		return bankListForSalary;
	}
	public void setBankListForSalary(List<String> bankListForSalary) {
		this.bankListForSalary = bankListForSalary;
	}
	public List<Integer> getPincodesOfCityOffice() {
		return pincodesOfCityOffice;
	}
	public void setPincodesOfCityOffice(List<Integer> pincodesOfCityOffice) {
		this.pincodesOfCityOffice = pincodesOfCityOffice;
	}
	public List<SamplePOJO> getEmployees() {
		return employees;
	}
	public void setEmployees(List<SamplePOJO> employees) {
		this.employees = employees;
	}
	public List<Contractors> getContractors() {
		return contractors;
	}
	public void setContractors(List<Contractors> contractors) {
		this.contractors = contractors;
	}
	public CompanyPFDetails getCompanyPFDetails() {
		return companyPFDetails;
	}
	public void setCompanyPFDetails(CompanyPFDetails companyPFDetails) {
		this.companyPFDetails = companyPFDetails;
	}
    
     
	
    
}
