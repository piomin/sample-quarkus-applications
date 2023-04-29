package pl.piomin.samples.quarkus.graphql.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Organization {
	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
	private Long id;
	private String name;
	@OneToMany(mappedBy = "organization")
	private Set<Department> departments;
	@OneToMany(mappedBy = "organization")
	private Set<Employee> employees;
}
