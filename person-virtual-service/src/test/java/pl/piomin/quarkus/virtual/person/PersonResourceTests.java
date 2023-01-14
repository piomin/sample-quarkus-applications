package pl.piomin.quarkus.virtual.person;

import io.quarkus.test.junit.QuarkusTest;
import org.instancio.Instancio;
import org.instancio.Select;
import org.junit.jupiter.api.Test;
import pl.piomin.quarkus.virtual.person.model.Person;

@QuarkusTest
public class PersonResourceTests {

    @Test
    void add() {
        Person person = Instancio.of(Person.class)
                .ignore(Select.field("id"))
                .create();
    }
}
