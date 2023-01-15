package pl.piomin.samples.quarkus.graphql.client;

import io.smallrye.graphql.client.typesafe.api.GraphQLClientApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
import pl.piomin.samples.quarkus.graphql.domain.EmployeeInput;
import pl.piomin.samples.quarkus.graphql.filter.EmployeeFilter;
import pl.piomin.samples.quarkus.graphql.message.Employee;

import java.util.List;

@GraphQLClientApi(configKey = "employee-client")
public interface EmployeeClient {

    List<Employee> employees();
    Employee employee(@Name("id") Long id);
    List<Employee> employeesWithFilter(@Name("filter") EmployeeFilter filter);
    @Mutation
    Employee newEmployee(@Name("input") EmployeeInput employee);
}
