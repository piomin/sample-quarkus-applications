package pl.piomin.samples.quarkus.employee.resource

import org.jboss.resteasy.annotations.jaxrs.PathParam
import pl.piomin.samples.quarkus.employee.domain.Employee
import pl.piomin.samples.quarkus.employee.repository.EmployeeRepository
import jakarta.annotation.security.PermitAll
import jakarta.annotation.security.RolesAllowed
import jakarta.transaction.Transactional
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class EmployeeResource(val repository: EmployeeRepository) {

    @POST
    @Transactional
    @RolesAllowed(value = ["manager", "admin"])
    fun add(employee: Employee): Response {
        repository.persist(employee)
        return Response.ok(employee).status(201).build()
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @RolesAllowed("admin")
    fun delete(@PathParam id: Long) {
        repository.deleteById(id)
    }

    @GET
    @PermitAll
    fun findAll(): List<Employee> = repository.listAll()

    @GET
    @Path("/{id}")
    @RolesAllowed(value = ["manager", "admin", "viewer"])
    fun findById(@PathParam id: Long): Employee?
            = repository.findById(id)

    @GET
    @Path("/first-name/{firstName}/last-name/{lastName}")
    @RolesAllowed(value = ["manager", "admin", "viewer"])
    fun findByFirstNameAndLastName(@PathParam firstName: String,
                          @PathParam lastName: String): List<Employee>
            = repository.findByFirstNameAndLastName(firstName, lastName)

    @GET
    @Path("/salary/{salary}")
    @RolesAllowed(value = ["manager", "admin", "viewer"])
    fun findBySalary(@PathParam salary: Int): List<Employee>
            = repository.findBySalary(salary)

    @GET
    @Path("/salary-greater-than/{salary}")
    @RolesAllowed(value = ["manager", "admin", "viewer"])
    fun findBySalaryGreaterThan(@PathParam salary: Int): List<Employee>
            = repository.findBySalaryGreaterThan(salary)

}