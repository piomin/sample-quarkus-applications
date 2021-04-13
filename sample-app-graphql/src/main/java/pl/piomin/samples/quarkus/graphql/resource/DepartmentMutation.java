package pl.piomin.samples.quarkus.graphql.resource;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;
import pl.piomin.samples.quarkus.graphql.domain.Department;
import pl.piomin.samples.quarkus.graphql.domain.DepartmentInput;
import pl.piomin.samples.quarkus.graphql.domain.Organization;
import pl.piomin.samples.quarkus.graphql.repository.DepartmentRepository;
import pl.piomin.samples.quarkus.graphql.repository.OrganizationRepository;

@GraphQLApi
public class DepartmentMutation {

    DepartmentRepository departmentRepository;
    OrganizationRepository organizationRepository;

    DepartmentMutation(DepartmentRepository departmentRepository, OrganizationRepository organizationRepository) {
        this.departmentRepository = departmentRepository;
        this.organizationRepository = organizationRepository;
    }

    @Query("newDepartment")
    public Department newDepartment(DepartmentInput departmentInput) {
        Organization organization = organizationRepository.findById(departmentInput.getOrganizationId());
        Department department = new Department(null, departmentInput.getName(), null, organization);
        departmentRepository.persist(department);
        return department;
    }

}
