package sr.unasat.college.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import sr.unasat.college.entities.Department;
import sr.unasat.college.entities.Employee;

import java.util.List;

public class DepartmentRepository {

    private EntityManager entityManager;

    public DepartmentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Department> getDepartment() {
        String query = "select d from Department d";
        TypedQuery<Department> typedQuery = entityManager.createQuery(query, Department.class);
        List<Department> departmentList = typedQuery.getResultList();
        return departmentList;
    }

    public Department createDepartment(Department department) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(department);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return department;
    }

    public Department deleteDepartment(Department department) {
        try {
            entityManager.getTransaction().begin();
            entityManager.find(Department.class, department.getId());
            if (department != null) entityManager.remove(department);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return department;
    }

    public Department updateDepartment(Department department){
        try{
            entityManager.getTransaction().begin();
/*            String findQuery = "from Person where id = :person_id";
            Query query = entityManager.createQuery(findQuery);
            query.setParameter("person_id", person.getId());*/
            entityManager.find(Department.class, department.getId());
            entityManager.merge(department);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return department;
    }
}

