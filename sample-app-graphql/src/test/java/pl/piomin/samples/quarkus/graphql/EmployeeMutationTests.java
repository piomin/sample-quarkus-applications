package pl.piomin.samples.quarkus.graphql;

import io.quarkus.test.junit.QuarkusTest;
import org.instancio.Instancio;
import org.instancio.Select;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.piomin.samples.quarkus.graphql.client.EmployeeClient;
import pl.piomin.samples.quarkus.graphql.domain.EmployeeInput;
import pl.piomin.samples.quarkus.graphql.message.Employee;

import jakarta.inject.Inject;
import java.util.List;

//@QuarkusTest
public class EmployeeMutationTests {

    @Inject
    EmployeeClient employeeClient;

//    @Test
    void add() {
        EmployeeInput employee = Instancio.of(EmployeeInput.class)
                .set(Select.field("departmentId"), 1L)
                .set(Select.field("organizationId"), 1L)
                .create();
        Employee employeeOutput = employeeClient.newEmployee(employee);
        Assertions.assertNotNull(employee);
    }
}
