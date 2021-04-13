package pl.piomin.samples.quarkus.graphql.resource;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;
import pl.piomin.samples.quarkus.graphql.domain.Employee;
import pl.piomin.samples.quarkus.graphql.filter.EmployeeFilter;
import pl.piomin.samples.quarkus.graphql.repository.EmployeeRepository;

import java.util.List;

@GraphQLApi
public class EmployeeFetcher {

    private EmployeeRepository repository;

    public EmployeeFetcher(EmployeeRepository repository){
        this.repository = repository;
    }

    @Query("employees")
    public List<Employee> findAll() {
        return repository.listAll();
    }

    @Query("employee")
    public Employee findById(@Name("id") Long id) {
        return repository.findById(id);
    }

    @Query("employeesWithFilter")
    public List<Employee> findWithFilter(@Name("filter") EmployeeFilter filter) {
        return repository.findByCriteria(filter);
    }

}
