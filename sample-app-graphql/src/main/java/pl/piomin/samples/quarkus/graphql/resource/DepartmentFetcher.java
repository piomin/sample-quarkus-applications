package pl.piomin.samples.quarkus.graphql.resource;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;
import pl.piomin.samples.quarkus.graphql.domain.Department;
import pl.piomin.samples.quarkus.graphql.repository.DepartmentRepository;

import java.util.List;

@GraphQLApi
public class DepartmentFetcher {

    private DepartmentRepository repository;

    DepartmentFetcher(DepartmentRepository repository) {
        this.repository = repository;
    }

    @Query("departments")
    public List<Department> findAll() {
        return repository.findAllByCriteria();
    }

    @Query("department")
    public Department findById(@Name("id") Long id) {
        return repository.findByIdWithCriteria(id);
    }

}
