package pl.piomin.samples.quarkus.graphql.client;

import io.smallrye.graphql.client.typesafe.api.GraphQLClientApi;
import org.eclipse.microprofile.graphql.Name;
import pl.piomin.samples.quarkus.graphql.message.Organization;

import java.util.List;

@GraphQLClientApi(configKey = "organization-client")
public interface OrganizationClient {

    List<Organization> organizations();
    Organization organization(@Name("id") Long id);
    Organization addOrganization(@Name("organization") Organization organization);
}
