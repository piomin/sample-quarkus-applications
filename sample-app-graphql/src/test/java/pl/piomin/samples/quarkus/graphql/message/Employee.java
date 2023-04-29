package pl.piomin.samples.quarkus.graphql.message;

import lombok.*;

import jakarta.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	private Long id;
	private String firstName;
	private String lastName;
	private String position;
	private int salary;
	private int age;
	private Organization organization;
	private Department department;
}
