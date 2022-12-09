package sr.unasat.college.service;

import sr.unasat.college.configuration.JPAConfig;
import sr.unasat.college.entities.Employee;
import sr.unasat.college.repository.EmployeeRepository;

import java.util.List;

public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(){ this.repository = new EmployeeRepository(JPAConfig.getEntityManager()); }

    public List<Employee> getEmployees(){ return repository.getEmployees(); }

    public Employee createEmployee(Employee employee){
        return repository.createEmployee(employee);
    }

    public Employee deleteEmployee(Employee employee){
        return repository.deleteEmployee(employee);
    }

    public Employee updateEmployee(Employee employee){
        return repository.updateEmployee(employee);
    }

}
