package pl.piomin.samples.quarkus.employee.domain

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.Entity

@Entity
data class Employee(var firstName: String = "",
                    var lastName: String = "",
                    var position: String = "",
                    var salary: Int = 0,
                    var organizationId: Int? = null,
                    var departmentId: Int? = null): PanacheEntity()