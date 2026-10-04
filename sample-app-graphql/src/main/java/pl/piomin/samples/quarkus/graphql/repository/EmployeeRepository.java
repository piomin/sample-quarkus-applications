package pl.piomin.samples.quarkus.graphql.repository;

import graphql.schema.DataFetchingEnvironment;
import graphql.schema.DataFetchingFieldSelectionSet;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.smallrye.graphql.api.Context;
import pl.piomin.samples.quarkus.graphql.domain.Employee;
import pl.piomin.samples.quarkus.graphql.filter.EmployeeFilter;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import java.util.List;

@ApplicationScoped
public class EmployeeRepository implements PanacheRepository<Employee> {

    private EntityManager em;
    private Context context;

    public EmployeeRepository(EntityManager em, Context context) {
        this.em = em;
        this.context = context;
    }

    private void applyJoinFetches(Root<Employee> root, DataFetchingFieldSelectionSet selectionSet) {
        if (selectionSet.contains("department")) {
            root.fetch("department", JoinType.LEFT);
        }
        if (selectionSet.contains("organization")) {
            root.fetch("organization", JoinType.LEFT);
        }
    }

    public List<Employee> findAllByCriteria() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = builder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        DataFetchingEnvironment dfe = context.unwrap(DataFetchingEnvironment.class);
        applyJoinFetches(root, dfe.getSelectionSet());
        criteriaQuery.select(root).distinct(true);
        return em.createQuery(criteriaQuery).getResultList();
    }

    public Employee findByIdWithCriteria(Long id) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = builder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        DataFetchingEnvironment dfe = context.unwrap(DataFetchingEnvironment.class);
        applyJoinFetches(root, dfe.getSelectionSet());
        criteriaQuery.where(builder.equal(root.get("id"), id));
        return em.createQuery(criteriaQuery).getSingleResult();
    }

    public List<Employee> findByCriteria(EmployeeFilter filter) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = builder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        DataFetchingEnvironment dfe = context.unwrap(DataFetchingEnvironment.class);
        applyJoinFetches(root, dfe.getSelectionSet());
        Predicate predicate = null;
        if (filter.getSalary() != null)
            predicate = filter.getSalary().generateCriteria(builder, root.get("salary"));
        if (filter.getAge() != null)
            predicate = (predicate == null ?
                    filter.getAge().generateCriteria(builder, root.get("age")) :
                    builder.and(predicate, filter.getAge().generateCriteria(builder, root.get("age"))));
        if (filter.getPosition() != null)
            predicate = (predicate == null ? filter.getPosition().generateCriteria(builder, root.get("position")) :
                    builder.and(predicate, filter.getPosition().generateCriteria(builder, root.get("position"))));

        if (predicate != null)
            criteriaQuery.where(predicate);

        criteriaQuery.select(root).distinct(true);
        return em.createQuery(criteriaQuery).getResultList();
    }

}
