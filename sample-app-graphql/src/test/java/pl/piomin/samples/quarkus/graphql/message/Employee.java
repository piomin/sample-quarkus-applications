package pl.piomin.samples.quarkus.graphql.message;

import lombok.*;
import pl.piomin.samples.quarkus.graphql.domain.Department;
import pl.piomin.samples.quarkus.graphql.domain.Organization;

import javax.persistence.*;

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
}
