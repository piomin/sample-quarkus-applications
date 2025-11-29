package pl.piomin.samples.quarkus.graphql.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Objects;
import java.util.Set;

@Entity
public class Organization {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@OneToMany(mappedBy = "organization")
	private Set<Department> departments;
	@OneToMany(mappedBy = "organization")
	private Set<Employee> employees;

	public Organization() {
	}

	public Organization(Long id, String name, Set<Department> departments, Set<Employee> employees) {
		this.id = id;
		this.name = name;
		this.departments = departments;
		this.employees = employees;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;

		Organization that = (Organization) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	@Override
	public String toString() {
		return "Organization{" +
				"name='" + name + '\'' +
				", id=" + id +
				'}';
	}
}
