package pl.piomin.quarkus.person.resource;


import org.jboss.logging.Logger;
import pl.piomin.quarkus.person.model.Person;
import pl.piomin.quarkus.person.repository.PersonRepository;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import java.util.List;

@Path("/persons")
public class PersonResource {

    @Inject
    PersonRepository personRepository;
    @Inject
    Logger log;

    @POST
    @Transactional
    public Person addPerson(Person person) {
        personRepository.persist(person);
        return person;
    }

    @GET
    public List<Person> getPersons() {
        return personRepository.listAll();
    }

    @GET
    @Path("/name/{name}")
    public List<Person> getPersonsByName(@PathParam("name") String name) {
        return personRepository.findByName(name);
    }

    @GET
    @Path("/age-greater-than/{age}")
    public List<Person> getPersonsByName(@PathParam("age") int age) {
        return personRepository.findByAgeGreaterThan(age);
    }

    @GET
    @Path("/{id}")
    public Person getPersonById(@PathParam("id") Long id) {
        log.infof("getPersonById(%d)", id);
        return personRepository.findById(id);
    }

}
