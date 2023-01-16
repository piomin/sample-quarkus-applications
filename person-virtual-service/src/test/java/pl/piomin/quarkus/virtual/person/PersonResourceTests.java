package pl.piomin.quarkus.virtual.person;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.instancio.Instancio;
import org.instancio.Select;
import org.junit.jupiter.api.Test;
import pl.piomin.quarkus.virtual.person.model.Person;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;


@QuarkusTest
public class PersonResourceTests {

    @Test
    void getAll() {
        given().get("/persons")
                .then()
                .statusCode(200)
                .assertThat().body("size()", is(1000));
    }

    @Test
    void add() {
        Person person = Instancio.of(Person.class)
                .ignore(Select.field("id"))
                .create();
        given().body(person).contentType(ContentType.JSON)
                .post("/persons")
                .then()
                .statusCode(200);
    }
}
