package pl.piomin.quarkus.grpc;

import com.google.protobuf.Empty;
import com.google.protobuf.Int64Value;
import io.quarkus.grpc.GrpcClient;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import pl.piomin.quarkus.grpc.model.PersonProto;
import pl.piomin.quarkus.grpc.model.PersonsService;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonsServiceTests {

    static Long newId;

    @GrpcClient
    PersonsService client;

    @Test
    @Order(1)
    void shouldAddNew() throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<Long> message = new CompletableFuture<>();
        client.addPerson(PersonProto.Person.newBuilder()
                        .setName("Test")
                        .setAge(20)
                        .setGender(PersonProto.Gender.MALE)
                        .build())
                .subscribe().with(res -> message.complete(res.getId()));
        Long id = message.get(1, TimeUnit.SECONDS);
        assertNotNull(id);
        newId = id;
    }

    @Test
    @Order(2)
    void shouldFindAll() throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<List<PersonProto.Person>> message = new CompletableFuture<>();
        client.findAll(Empty.newBuilder().build())
                .subscribe().with(res -> message.complete(res.getPersonList()));
        List<PersonProto.Person> list = message.get(1, TimeUnit.SECONDS);
        assertNotNull(list);
        assertFalse(list.isEmpty());
    }

    @Test
    @Order(2)
    void shouldFindById() throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<PersonProto.Person> message = new CompletableFuture<>();
        client.findById(Int64Value.newBuilder().setValue(newId).build())
                .subscribe().with(message::complete);
        PersonProto.Person p = message.get(1, TimeUnit.SECONDS);
        assertNotNull(p);
        assertEquals("Test", p.getName());
        assertEquals(newId, p.getId());
    }
}
