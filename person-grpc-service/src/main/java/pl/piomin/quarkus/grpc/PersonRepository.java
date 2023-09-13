package pl.piomin.quarkus.grpc;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<PersonEntity> {

    public Uni<List<PersonEntity>> findByName(String name){
        return find("name", name).list();
    }

    public Uni<List<PersonEntity>> findByAge(int age){
        return find("age", age).list();
    }
}
