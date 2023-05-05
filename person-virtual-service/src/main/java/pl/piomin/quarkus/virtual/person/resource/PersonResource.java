package pl.piomin.quarkus.virtual.person.resource;

import io.smallrye.common.annotation.RunOnVirtualThread;
import org.jboss.logging.Logger;
import pl.piomin.quarkus.virtual.person.model.Person;
import pl.piomin.quarkus.virtual.person.repository.PersonRepositoryAsyncAwait;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import java.util.List;

@Path("/persons")
@RunOnVirtualThread
public class PersonResource {

    @Inject
    PersonRepositoryAsyncAwait personRepository;
    @Inject
    Logger log;

    @POST
    public Person addPerson(Person person) {
        person = personRepository.save(person);
        return person;
    }

    @GET
    public List<Person> getPersons() {
        return personRepository.findAll();
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
        log.infof("(%s) getPersonById(%d)", Thread.currentThread(), id);
        return personRepository.findById(id);
    }

}
