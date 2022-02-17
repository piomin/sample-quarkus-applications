package pl.piomin.quarkus.person.resource;


import pl.piomin.quarkus.person.model.Person;
import pl.piomin.quarkus.person.repository.PersonRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("/persons")
public class PersonResource {

    @Inject
    PersonRepository personRepository;

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
        return personRepository.findById(id);
    }

}
