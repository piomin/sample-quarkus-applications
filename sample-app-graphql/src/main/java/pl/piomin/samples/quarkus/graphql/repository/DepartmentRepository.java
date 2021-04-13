package pl.piomin.samples.quarkus.graphql.repository;

import graphql.schema.DataFetchingEnvironment;
import graphql.schema.DataFetchingFieldSelectionSet;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.smallrye.graphql.api.Context;
import pl.piomin.samples.quarkus.graphql.domain.Department;
import pl.piomin.samples.quarkus.graphql.domain.Employee;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;

@ApplicationScoped
public class DepartmentRepository implements PanacheRepository<Department> {

    private EntityManager em;
    private Context context;

    public DepartmentRepository(EntityManager em, Context context) {
        this.em = em;
        this.context = context;
    }

    public List<Department> findAllByCriteria() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Department> criteriaQuery = builder.createQuery(Department.class);
        Root<Department> root = criteriaQuery.from(Department.class);
        DataFetchingEnvironment dfe = context.unwrap(DataFetchingEnvironment.class);
        DataFetchingFieldSelectionSet selectionSet = dfe.getSelectionSet();
        if (selectionSet.contains("employees")) {
            root.fetch("employees", JoinType.LEFT);
        }
        if (selectionSet.contains("organization")) {
            root.fetch("organization", JoinType.LEFT);
        }
        criteriaQuery.select(root).distinct(true);
        return em.createQuery(criteriaQuery).getResultList();
    }

    public Department findByIdWithCriteria(Long id) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Department> criteriaQuery = builder.createQuery(Department.class);
        Root<Department> root = criteriaQuery.from(Department.class);
        DataFetchingEnvironment dfe = context.unwrap(DataFetchingEnvironment.class);
        DataFetchingFieldSelectionSet selectionSet = dfe.getSelectionSet();
        if (selectionSet.contains("employees")) {
            root.fetch("employees", JoinType.LEFT);
        }
        if (selectionSet.contains("organization")) {
            root.fetch("organization", JoinType.LEFT);
        }
        criteriaQuery.where(builder.equal(root.get("id"), id));
        return em.createQuery(criteriaQuery).getSingleResult();
    }
}
