package pl.piomin.samples.quarkus.graphql.resource;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
import pl.piomin.samples.quarkus.graphql.domain.Organization;
import pl.piomin.samples.quarkus.graphql.domain.OrganizationInput;
import pl.piomin.samples.quarkus.graphql.repository.OrganizationRepository;

@GraphQLApi
public class OrganizationMutation {

    OrganizationRepository repository;

    OrganizationMutation(OrganizationRepository repository) {
        this.repository = repository;
    }

    @Mutation("newOrganization")
    public Organization newOrganization(@Name("input")  OrganizationInput organizationInput) {
        Organization organization = (new Organization(null, organizationInput.getName(), null, null));
        repository.persist(organization);
        return organization;
    }

}
