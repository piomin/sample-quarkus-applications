package pl.piomin.samples.quarkus.graphql.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import pl.piomin.samples.quarkus.graphql.domain.Employee;
import pl.piomin.samples.quarkus.graphql.filter.EmployeeFilter;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.List;

@ApplicationScoped
public class EmployeeRepository implements PanacheRepository<Employee> {

    private EntityManager em;

    public EmployeeRepository(EntityManager em) {
        this.em = em;
    }

    public List<Employee> findByCriteria(EmployeeFilter filter) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = builder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
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

        return em.createQuery(criteriaQuery).getResultList();
    }

}
