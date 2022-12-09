package sr.unasat.college.service;

import sr.unasat.college.configuration.JPAConfig;
import sr.unasat.college.entities.Department;
import sr.unasat.college.repository.DepartmentRepository;

import java.util.List;

public class DepartmentService {

    private final DepartmentRepository repository;

    public DepartmentService(){ this.repository = new DepartmentRepository(JPAConfig.getEntityManager());}

    public List<Department> getDepartment(){ return repository.getDepartment();}

    public Department createDepartment(Department department){
        return repository.createDepartment(department);
    }

    public Department deleteDepartment(Department department){
        return repository.deleteDepartment(department);
    }

    public Department updateDepartment(Department department){
        return repository.updateDepartment(department);
    }
}
