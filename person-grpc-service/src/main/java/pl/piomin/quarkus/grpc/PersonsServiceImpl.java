package pl.piomin.quarkus.grpc;

import com.google.protobuf.Empty;
import com.google.protobuf.Int32Value;
import com.google.protobuf.Int64Value;
import com.google.protobuf.StringValue;
import io.quarkus.grpc.GrpcService;
import io.quarkus.grpc.RegisterInterceptor;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import pl.piomin.quarkus.grpc.model.PersonProto;
import pl.piomin.quarkus.grpc.model.PersonsService;

import java.util.List;

@GrpcService
@WithSession
@RegisterInterceptor(LogInterceptor.class)
public class PersonsServiceImpl implements PersonsService {

    private PersonRepository repository;

    public PersonsServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public Uni<PersonProto.Persons> findByName(StringValue request) {
        return repository.findByName(request.getValue())
                .map(this::mapToPersons);
    }

    @Override
    public Uni<PersonProto.Persons> findByAge(Int32Value request) {
        return repository.findByAge(request.getValue())
                .map(this::mapToPersons);
    }

    @Override
    public Uni<PersonProto.Person> findById(Int64Value request) {
        return repository.findById(request.getValue())
                .map(this::mapToPerson);
    }

    @Override
    public Uni<PersonProto.Persons> findAll(Empty request) {
        return repository.findAll().list()
                .map(this::mapToPersons);
    }

    @Override
    @WithTransaction
    public Uni<PersonProto.Person> addPerson(PersonProto.Person request) {
        PersonEntity entity = new PersonEntity();
        entity.age = request.getAge();
        entity.name = request.getName();
        entity.gender = Gender.valueOf(request.getGender().name());
        return repository.persist(entity).map(personEntity -> mapToPerson(entity));
    }

    private PersonProto.Persons mapToPersons(List<PersonEntity> list) {
        PersonProto.Persons.Builder builder = PersonProto.Persons.newBuilder();
        list.forEach(p -> builder.addPerson(mapToPerson(p)));
        return builder.build();
    }

    private PersonProto.Person mapToPerson(PersonEntity entity) {
        PersonProto.Person.Builder builder = PersonProto.Person.newBuilder();
        if (entity != null) {
            return builder.setAge(entity.age)
                    .setName(entity.name)
                    .setId(entity.id)
                    .setGender(PersonProto.Gender.valueOf(entity.gender.name()))
                    .build();
        } else {
            return null;
        }
    }
}
