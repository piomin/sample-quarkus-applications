package pl.piomin.samples.quarkus.graphql.repository;

import io.quarkus.runtime.StartupEvent;
import pl.piomin.samples.quarkus.graphql.domain.Department;
import pl.piomin.samples.quarkus.graphql.domain.Employee;
import pl.piomin.samples.quarkus.graphql.domain.Organization;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.transaction.Transactional;

@ApplicationScoped
public class DemoDataStartup {

    private DepartmentRepository departmentRepository;
    private EmployeeRepository employeeRepository;
    private OrganizationRepository organizationRepository;

    public DemoDataStartup(DepartmentRepository departmentRepository,
                           EmployeeRepository employeeRepository,
                           OrganizationRepository organizationRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.organizationRepository = organizationRepository;
    }

    @Transactional
    void onStart(@Observes StartupEvent ev) {
        Organization o1 = new Organization(null, "Test1", null, null);
        Organization o2 = new Organization(null, "Test2", null, null);
        Organization o3 = new Organization(null, "Test3", null, null);
        organizationRepository.persist(o1);
        organizationRepository.persist(o2);
        organizationRepository.persist(o3);

        Department d1 = new Department(null, "Test1", null, o1);
        Department d2 = new Department(null, "Test2", null, o1);
        Department d3 = new Department(null, "Test3", null, o2);
        Department d4 = new Department(null, "Test4", null, o2);
        Department d5 = new Department(null, "Test5", null, o2);
        Department d6 = new Department(null, "Test6", null, o3);
        departmentRepository.persist(d1);
        departmentRepository.persist(d2);
        departmentRepository.persist(d3);
        departmentRepository.persist(d4);
        departmentRepository.persist(d5);
        departmentRepository.persist(d6);

        Employee e1 = new Employee(null, "Name01", "01", "Dev", 10000, 40, d1, o1);
        Employee e2 = new Employee(null, "Name02", "02", "Dev", 20000, 42, d1, o1);
        Employee e3 = new Employee(null, "Name03", "03", "Dev", 15000, 27, d2, o1);
        Employee e4 = new Employee(null, "Name04", "04", "Dev", 13000, 29, d3, o2);
        Employee e5 = new Employee(null, "Name05", "05", "Dev", 12000, 21, d3, o2);
        Employee e6 = new Employee(null, "Name06", "06", "Dev", 22000, 33, d4, o2);
        Employee e7 = new Employee(null, "Name07", "07", "Dev", 11000, 33, d4, o2);
        Employee e8 = new Employee(null, "Name08", "08", "Dev", 18000, 35, d4, o2);
        Employee e9 = new Employee(null, "Name09", "09", "Dev", 11000, 30, d5, o2);
        Employee e10 = new Employee(null, "Name10", "10", "Dev", 12000, 50, d6, o3);
        employeeRepository.persist(e1);
        employeeRepository.persist(e2);
        employeeRepository.persist(e3);
        employeeRepository.persist(e4);
        employeeRepository.persist(e5);
        employeeRepository.persist(e6);
        employeeRepository.persist(e7);
        employeeRepository.persist(e8);
        employeeRepository.persist(e9);
        employeeRepository.persist(e10);
    }
}
