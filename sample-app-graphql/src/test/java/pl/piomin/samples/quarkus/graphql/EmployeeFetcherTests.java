package pl.piomin.samples.quarkus.graphql;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.piomin.samples.quarkus.graphql.client.EmployeeClient;
import pl.piomin.samples.quarkus.graphql.filter.EmployeeFilter;
import pl.piomin.samples.quarkus.graphql.filter.FilterField;
import pl.piomin.samples.quarkus.graphql.message.Employee;

import javax.inject.Inject;
import java.util.List;

@QuarkusTest
public class EmployeeFetcherTests {

    @Inject
    EmployeeClient employeeClient;

    @Test
    void fetchAll() {
        List<Employee> employees = employeeClient.employees();
        Assertions.assertTrue(employees.size() > 0);
    }

    @Test
    void fetchById() {
        Employee employee = employeeClient.employee(10L);
        Assertions.assertNotNull(employee);
    }

    @Test
    void fetchByFilter() {
        EmployeeFilter filter = new EmployeeFilter();
        FilterField filterField = new FilterField();
        filterField.setValue("10000");
        filterField.setOperator("gt");
        filter.setSalary(filterField);
        List<Employee> employees = employeeClient.employeesWithFilter(filter);
        Assertions.assertTrue(employees.size() > 0);
    }
}
