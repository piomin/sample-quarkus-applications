package pl.piomin.samples.quarkus.graphql.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Employee {
	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
	private Long id;
	private String firstName;
	private String lastName;
	private String position;
	private int salary;
	private int age;
	@ManyToOne(fetch = FetchType.LAZY)
	private Department department;
	@ManyToOne(fetch = FetchType.LAZY)
	private Organization organization;
}
