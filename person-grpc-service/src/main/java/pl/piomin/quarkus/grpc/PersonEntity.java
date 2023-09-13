package pl.piomin.quarkus.grpc;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class PersonEntity extends PanacheEntity {

    public String name;
    public int age;
    public Gender gender;
}
