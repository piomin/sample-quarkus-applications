package pl.piomin.samples.quarkus.graphql.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeInput {
	private String firstName;
	private String lastName;
	private String position;
	private int salary;
	private int age;
	private Long departmentId;
	private Long organizationId;
}
