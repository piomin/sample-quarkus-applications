package pl.piomin.samples.quarkus.employee.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import pl.piomin.samples.quarkus.employee.domain.Employee
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class EmployeeRepository: PanacheRepository<Employee> {
    fun findByFirstNameAndLastName(firstName: String, lastName: String): List<Employee> =
           list("firstName = ?1 and lastName = ?2", firstName, lastName)

    fun findBySalary(salary: Int): List<Employee> = list("salary", salary)

    fun findBySalaryGreaterThan(salary: Int): List<Employee> = list("salary > ?1", salary)
}