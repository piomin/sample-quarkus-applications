package pl.piomin.samples.quarkus.graphql;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.piomin.samples.quarkus.graphql.client.DepartmentClient;
import pl.piomin.samples.quarkus.graphql.message.Department;

import javax.inject.Inject;
import java.util.List;

@QuarkusTest
public class DepartmentFetcherTests {

    @Inject
    DepartmentClient departmentClient;

    @Test
    void fetchAll() {
        List<Department> departments = departmentClient.departments();
        Assertions.assertTrue(departments.size() > 0);
    }

//    @Test
    void fetchById() {
        Department department = departmentClient.department(1L);
        Assertions.assertNotNull(department);
        Assertions.assertNotNull(department.getName());
    }
    
}
