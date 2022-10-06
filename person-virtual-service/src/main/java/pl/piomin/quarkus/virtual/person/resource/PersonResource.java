package pl.piomin.quarkus.virtual.person.resource;

import io.smallrye.common.annotation.RunOnVirtualThread;
import org.jboss.logging.Logger;
import pl.piomin.quarkus.virtual.person.model.Person;
import pl.piomin.quarkus.virtual.person.repository.PersonRepositoryAsyncAwait;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
