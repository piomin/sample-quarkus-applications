package pl.piomin.samples.quarkus.graphql.message;

public class Department {
    private Long id;
    private String name;
    private Organization organization;

    public Department() {
    }

    public Department(Long id, String name, Organization organization) {
        this.id = id;
        this.name = name;
        this.organization = organization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
