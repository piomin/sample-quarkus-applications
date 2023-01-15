package pl.piomin.samples.quarkus.graphql.client;

import io.smallrye.graphql.client.typesafe.api.GraphQLClientApi;
import org.eclipse.microprofile.graphql.Name;
import pl.piomin.samples.quarkus.graphql.message.Department;

import java.util.List;

@GraphQLClientApi(configKey = "department-client")
public interface DepartmentClient {

    List<Department> departments();
    Department department(@Name("id") Long id);
    Department addDepartment(@Name("department") Department department);
}
