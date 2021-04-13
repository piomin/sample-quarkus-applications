package pl.piomin.samples.quarkus.graphql.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import pl.piomin.samples.quarkus.graphql.domain.Organization;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrganizationRepository implements PanacheRepository<Organization> {
}
