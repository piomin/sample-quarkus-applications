package pl.piomin.samples.quarkus.graphql.resource;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;
import pl.piomin.samples.quarkus.graphql.domain.Organization;
import pl.piomin.samples.quarkus.graphql.repository.OrganizationRepository;

import java.util.List;

@GraphQLApi
public class OrganizationFetcher {

    private OrganizationRepository repository;

    OrganizationFetcher(OrganizationRepository repository) {
        this.repository = repository;
    }

    @Query("organizations")
    public List<Organization> findAll() {
        return repository.listAll();
    }

    @Query("organization")
    public Organization findById(@Name("id") Long id) {
        return repository.findById(id);
    }
}
