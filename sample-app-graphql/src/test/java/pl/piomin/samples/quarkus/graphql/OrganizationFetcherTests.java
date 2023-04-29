package pl.piomin.samples.quarkus.graphql;

import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.graphql.client.GraphQLClient;
import io.smallrye.graphql.client.dynamic.api.DynamicGraphQLClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.piomin.samples.quarkus.graphql.client.OrganizationClient;
import pl.piomin.samples.quarkus.graphql.message.Organization;

import jakarta.inject.Inject;
import java.util.List;


@QuarkusTest
public class OrganizationFetcherTests {

    @Inject
    OrganizationClient organizationClient;

    @Test
    void fetchAll() {
        List<Organization> organizations = organizationClient.organizations();
        Assertions.assertTrue(organizations.size() > 0);
    }

    @Test
    void fetchById() {
        Organization organization = organizationClient.organization(1L);
        Assertions.assertNotNull(organization);
        Assertions.assertNotNull(organization.getName());
    }
    
}
