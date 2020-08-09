package pl.piomin.samples.quarkus.employee

import io.quarkus.test.junit.QuarkusTest
import io.restassured.http.ContentType
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test
import pl.piomin.samples.quarkus.employee.domain.Employee

@QuarkusTest
class EmployeeResourceTest {

    @Test
    fun testAddEmployee() {
        val emp = Employee(firstName = "John", lastName = "Smith", position = "Developer", salary = 20000)
        given().body(emp).contentType(ContentType.JSON)
                .post("/employees")
                .then()
                .statusCode(201)
    }

    @Test
    fun testGetAll() {
        given().get("/employees")
                .then()
                .statusCode(200)
                .assertThat().body("size()", `is`(1))
    }

}