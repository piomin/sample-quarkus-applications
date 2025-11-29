package pl.piomin.samples.quarkus.graphql.domain;

public class EmployeeInput {
	private String firstName;
	private String lastName;
	private String position;
	private int salary;
	private int age;
	private Long departmentId;
	private Long organizationId;

	public EmployeeInput() {
	}

	public EmployeeInput(String firstName, String lastName, String position, int salary, int age, Long departmentId, Long organizationId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.salary = salary;
		this.age = age;
		this.departmentId = departmentId;
		this.organizationId = organizationId;
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

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}



}
