package pl.piomin.quarkus.person.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import pl.piomin.quarkus.person.model.Person;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {

    public List<Person> findByName(String name) {
        return find("name", name).list();
    }

    public List<Person> findByAgeGreaterThan(int age) {
        return find("age > ?1", age).list();
    }
}
