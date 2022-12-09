package sr.unasat.college.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import sr.unasat.college.entities.Employee;

import java.util.List;

public class EmployeeRepository {

    private EntityManager entityManager;

    public EmployeeRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public List<Employee> getEmployees(){
        String query = "select e from Employee e";
        TypedQuery<Employee> typedQuery = entityManager.createQuery(query, Employee.class);
        List<Employee> employeeList  = typedQuery.getResultList();
        return employeeList;
    }

    public Employee createEmployee(Employee employee){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return employee;
    }

    public Employee deleteEmployee(Employee employee){
        try{
            entityManager.getTransaction().begin();
            entityManager.find(Employee.class, employee.getId());
            if(employee != null)  entityManager.remove(employee);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return employee;
    }

    public Employee updateEmployee(Employee employee){
        try{
            entityManager.getTransaction().begin();
/*            String findQuery = "from Person where id = :person_id";
            Query query = entityManager.createQuery(findQuery);
            query.setParameter("person_id", person.getId());*/
            entityManager.find(Employee.class, employee.getId());
            entityManager.merge(employee);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return employee;
    }
}
