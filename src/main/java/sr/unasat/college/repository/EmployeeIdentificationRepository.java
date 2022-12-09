package sr.unasat.college.repository;

import jakarta.persistence.EntityManager;
import sr.unasat.college.entities.EmployeeIdentification;

public class EmployeeIdentificationRepository {

    private EntityManager entityManager;

    public EmployeeIdentificationRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    public EmployeeIdentification createEmployeeIdentification(EmployeeIdentification employeeIdentification){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(employeeIdentification);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
        return employeeIdentification;
    }
    public EmployeeIdentification deleteEmployeeIdentification(EmployeeIdentification employeeIdentification){
        try{
            entityManager.getTransaction().begin();
            entityManager.find(EmployeeIdentification.class, employeeIdentification.getId());
            if(employeeIdentification != null)  entityManager.remove(employeeIdentification);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return employeeIdentification;
    }


    public EmployeeIdentification updateEmployeeIdentification(EmployeeIdentification employeeIdentification){
        try{
            entityManager.getTransaction().begin();
            entityManager.find(EmployeeIdentification.class, employeeIdentification.getId());
            entityManager.merge(employeeIdentification);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return employeeIdentification;
    }
}
