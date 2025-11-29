package pl.piomin.samples.quarkus.graphql.domain;

import java.util.Objects;

public class DepartmentInput {
	private String name;
	private Long organizationId;

	public DepartmentInput() {
	}

	public DepartmentInput(String name, Long organizationId) {
		this.name = name;
		this.organizationId = organizationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;

		DepartmentInput that = (DepartmentInput) o;
		return Objects.equals(name, that.name) && Objects.equals(organizationId, that.organizationId);
	}

	@Override
	public int hashCode() {
		int result = Objects.hashCode(name);
		result = 31 * result + Objects.hashCode(organizationId);
		return result;
	}
}
