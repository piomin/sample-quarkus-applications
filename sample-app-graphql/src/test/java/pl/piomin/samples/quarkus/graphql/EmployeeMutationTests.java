package pl.piomin.samples.quarkus.graphql;

import io.quarkus.test.junit.QuarkusTest;
import org.instancio.Instancio;
import org.instancio.Select;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.piomin.samples.quarkus.graphql.client.EmployeeClient;
import pl.piomin.samples.quarkus.graphql.message.Employee;

import javax.inject.Inject;
import java.util.List;

@QuarkusTest
public class EmployeeMutationTests {

    @Inject
    EmployeeClient employeeClient;

    @Test
    void add() {
        Employee employee = Instancio.of(Employee.class)
//                .set(Select.field("departmentId"), 1)
//                .set(Select.field("organizationId"), 1)
                .create();
        employee = employeeClient.addEmployee(employee);
        Assertions.assertNotNull(employee);
        Assertions.assertNotNull(employee.getId());
    }
}
