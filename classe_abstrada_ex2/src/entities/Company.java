package entities;

public class Company extends TaxPayer {

	private Integer employees;
	
	public Company () {
		super();
	}
		
	public Company(String name, Double income, Integer employees) {
		super(name, income);
		this.employees = employees;
	}
	
	public Integer getEmployees() {
		return employees;
	}

	public void setEmployees(Integer employees) {
		this.employees = employees;
	}

	@Override
	public double tax() {
		if (employees > 10) {
			return getIncome() * 0.14;
		}
		else {
			return getIncome() * 0.16;
		}
	}

}
