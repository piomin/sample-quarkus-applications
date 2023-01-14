package pl.piomin.samples.quarkus.graphql.client;

import io.smallrye.graphql.client.typesafe.api.GraphQLClientApi;
import pl.piomin.samples.quarkus.graphql.domain.Department;

import java.util.List;

@GraphQLClientApi(configKey = "department-client")
public interface DepartmentClient {

    List<Department> departments();
    Department department(Long id);
    Department addDepartment(Department department);
}
