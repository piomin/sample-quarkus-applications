package pl.piomin.samples.quarkus.graphql.client;

import io.smallrye.graphql.client.typesafe.api.GraphQLClientApi;
import pl.piomin.samples.quarkus.graphql.message.Organization;

import java.util.List;

@GraphQLClientApi(configKey = "organization-client")
public interface OrganizationClient {

    List<Organization> organizations();
    Organization organization(Long id);
    Organization addOrganization(Organization organization);
}
