package pl.piomin.samples.quarkus.graphql.client;

import io.smallrye.graphql.client.typesafe.api.GraphQLClientApi;
import pl.piomin.samples.quarkus.graphql.filter.EmployeeFilter;
import pl.piomin.samples.quarkus.graphql.message.Employee;

import java.util.List;

@GraphQLClientApi(configKey = "employee-client")
public interface EmployeeClient {

    List<Employee> employees();
    Employee employee(Long id);
    List<Employee> employeesWithFilter(EmployeeFilter filter);
    Employee addEmployee(Employee employee);
}
