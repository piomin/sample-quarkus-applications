package pl.piomin.samples.quarkus.graphql.message;

public class Employee {
	private Long id;
	private String firstName;
	private String lastName;
	private String position;
	private int salary;
	private int age;
	private Organization organization;
	private Department department;

	public Employee() {
	}

	public Employee(Long id, String firstName, String lastName, String position, int salary, int age, Organization organization, Department department) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.salary = salary;
		this.age = age;
		this.organization = organization;
		this.department = department;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}
