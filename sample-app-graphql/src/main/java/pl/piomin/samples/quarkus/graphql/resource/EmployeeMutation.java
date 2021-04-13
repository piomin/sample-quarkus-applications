package pl.piomin.samples.quarkus.graphql.resource;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
import pl.piomin.samples.quarkus.graphql.domain.Department;
import pl.piomin.samples.quarkus.graphql.domain.Employee;
import pl.piomin.samples.quarkus.graphql.domain.EmployeeInput;
import pl.piomin.samples.quarkus.graphql.domain.Organization;
import pl.piomin.samples.quarkus.graphql.repository.DepartmentRepository;
import pl.piomin.samples.quarkus.graphql.repository.EmployeeRepository;
import pl.piomin.samples.quarkus.graphql.repository.OrganizationRepository;


@GraphQLApi
public class EmployeeMutation {

    DepartmentRepository departmentRepository;
    EmployeeRepository employeeRepository;
    OrganizationRepository organizationRepository;

    EmployeeMutation(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, OrganizationRepository organizationRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.organizationRepository = organizationRepository;
    }

    @Mutation("newEmployee")
    public Employee addEmployee(@Name("input") EmployeeInput employeeInput) {
        Department department = departmentRepository.findById(employeeInput.getDepartmentId());
        Organization organization = organizationRepository.findById(employeeInput.getOrganizationId());
        Employee employee = new Employee(null, employeeInput.getFirstName(), employeeInput.getLastName(),
                employeeInput.getPosition(), employeeInput.getAge(), employeeInput.getSalary(),
                department, organization);
        employeeRepository.persist(employee);
        return employee;
    }

}
