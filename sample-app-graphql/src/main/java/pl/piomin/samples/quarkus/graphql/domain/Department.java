package pl.piomin.samples.quarkus.graphql.domain;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
public class Department {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@OneToMany(mappedBy = "department")
	private Set<Employee> employees;
	@ManyToOne(fetch = FetchType.LAZY)
	private Organization organization;

	public Department() {
	}

	public Department(Long id, String name, Set<Employee> employees, Organization organization) {
		this.id = id;
		this.name = name;
		this.employees = employees;
		this.organization = organization;
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

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;

		Department that = (Department) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
}
