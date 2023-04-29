package pl.piomin.samples.quarkus.employee

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition
import org.eclipse.microprofile.openapi.annotations.info.Info
import jakarta.ws.rs.core.Application

@OpenAPIDefinition(info = Info(title = "Employee API", version = "1.0.0"))
class EmployeeApplication: Application()