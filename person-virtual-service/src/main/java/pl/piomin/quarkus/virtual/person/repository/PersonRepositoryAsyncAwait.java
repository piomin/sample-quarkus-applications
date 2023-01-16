package pl.piomin.quarkus.virtual.person.repository;

import io.quarkus.runtime.StartupEvent;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Row;
import io.vertx.mutiny.sqlclient.RowSet;
import io.vertx.mutiny.sqlclient.Tuple;
import net.datafaker.Faker;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;
import pl.piomin.quarkus.virtual.person.model.Gender;
import pl.piomin.quarkus.virtual.person.model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PersonRepositoryAsyncAwait {

    @Inject
    PgPool pgPool;
    @Inject
    Logger log;

    public Person save(Person person) {
        Long id = pgPool
                .preparedQuery("INSERT INTO person(name, age, gender) VALUES ($1, $2, $3) RETURNING id")
                .executeAndAwait(Tuple.of(person.getName(), person.getAge(), person.getGender()))
                .iterator().next().getLong("id");
        person.setId(id);
        return person;
    }

    public List<Person> findAll() {
        log.info("FindAll()" + Thread.currentThread());
        RowSet<Row> rowSet = pgPool
                .preparedQuery("SELECT id, name, age, gender FROM person")
                .executeAndAwait();
        return iterateAndCreate(rowSet);
    }

    public Person findById(Long id) {
        RowSet<Row> rowSet = pgPool
           .preparedQuery("SELECT id, name, age, gender FROM person WHERE id = $1")
           .executeAndAwait(Tuple.of(id));
        List<Person> persons = iterateAndCreate(rowSet);
        return persons.size() == 0 ? null : persons.get(0);
    }

    public List<Person> findByName(String name) {
        RowSet<Row> rowSet = pgPool
                .preparedQuery("SELECT id, name, age, gender FROM person WHERE id = $1")
                .executeAndAwait(Tuple.of(name));
        return iterateAndCreate(rowSet);
    }

    public List<Person> findByAgeGreaterThan(int age) {
        RowSet<Row> rowSet = pgPool
                .preparedQuery("SELECT id, name, age, gender FROM person WHERE age > $1")
                .executeAndAwait(Tuple.of(age));
        return iterateAndCreate(rowSet);
    }

    private List<Person> iterateAndCreate(RowSet<Row> rowSet) {
        List<Person> persons = new ArrayList<>();
        for (Row row : rowSet) {
            persons.add(Person.from(row));
        }
        return persons;
    }

    @Inject
    @ConfigProperty(name = "myapp.schema.create", defaultValue = "true")
    boolean schemaCreate;

    void config(@Observes StartupEvent ev) {
        if (schemaCreate) {
            initDb();
        }
    }

    private void initDb() {
        List<Tuple> persons = new ArrayList<>(1000);
        Faker faker = new Faker();
        for (int i = 0; i < 1000; i++) {
            String name = faker.name().fullName();
            String gender = faker.gender().binaryTypes().toUpperCase();
            int age = faker.number().numberBetween(18, 65);
            int externalId = faker.number().numberBetween(100000, 999999);
            persons.add(Tuple.of(name, age, gender, externalId));
        }

        pgPool.query("DROP TABLE IF EXISTS person").execute()
                .flatMap(r -> pgPool.query("""
                        create table person (
                          id serial primary key,
                          name varchar(255),
                          gender varchar(255),
                          age int,
                          external_id int
                        )
                        """).execute())
                .flatMap(r -> pgPool
                        .preparedQuery("insert into person(name, age, gender, external_id) values($1, $2, $3, $4)")
                        .executeBatch(persons))
                .await().indefinitely();
    }
}
