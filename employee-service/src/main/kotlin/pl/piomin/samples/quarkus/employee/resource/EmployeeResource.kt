package pl.piomin.samples.quarkus.employee.resource

import org.eclipse.microprofile.config.inject.ConfigProperty
import io.micrometer.core.annotation.Timed
import org.jboss.resteasy.annotations.jaxrs.PathParam
import pl.piomin.samples.quarkus.employee.domain.Employee
import pl.piomin.samples.quarkus.employee.repository.EmployeeRepository
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
    @Timed(value = "add")
    fun add(employee: Employee): Response {
        repository.persist(employee)
        return Response.ok(employee).status(201).build()
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @Timed(value = "delete")
    fun delete(@PathParam id: Long) {
        repository.deleteById(id)
    }

    @GET
    @Timed(value = "findAll")
    fun findAll(): List<Employee> = repository.listAll()

    @GET
    @Path("/{id}")
    @Timed(value = "findById")
    fun findById(@PathParam id: Long): Employee? = repository.findById(id)

    @GET
    @Path("/first-name/{firstName}/last-name/{lastName}")
    @Timed(value = "findByFirstNameAndLastName")
    fun findByFirstNameAndLastName(@PathParam firstName: String, @PathParam lastName: String): List<Employee>
            = repository.findByFirstNameAndLastName(firstName, lastName)

    @GET
    @Path("/salary/{salary}")
    @Timed(value = "findBySalary")
    fun findBySalary(@PathParam salary: Int): List<Employee> = repository.findBySalary(salary)

    @GET
    @Path("/salary-greater-than/{salary}")
    @Timed(value = "findBySalaryGreaterThan")
    fun findBySalaryGreaterThan(@PathParam salary: Int): List<Employee>
            = repository.findBySalaryGreaterThan(salary)

    @ConfigProperty(name = "property1")
    lateinit var property1: String

    @GET
    @Path("/property1")
    fun property1(): String = property1
}