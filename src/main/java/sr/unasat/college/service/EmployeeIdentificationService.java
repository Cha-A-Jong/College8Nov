package sr.unasat.college.service;

import sr.unasat.college.configuration.JPAConfig;
import sr.unasat.college.entities.EmployeeIdentification;
import sr.unasat.college.repository.EmployeeIdentificationRepository;

public class EmployeeIdentificationService {

    private final EmployeeIdentificationRepository employeeIdentificationRepository;

    public EmployeeIdentificationService(){
        this.employeeIdentificationRepository = new EmployeeIdentificationRepository(JPAConfig.getEntityManager());
    }

    public EmployeeIdentification createEmployeeIdentification(EmployeeIdentification employeeIdentification){
        return employeeIdentificationRepository.createEmployeeIdentification(employeeIdentification);
    }

    public EmployeeIdentification deleteEmployeeIdentification(EmployeeIdentification employeeIdentification){
        return employeeIdentificationRepository.deleteEmployeeIdentification(employeeIdentification);
    }

    public EmployeeIdentification updateEmployeeIdentification(EmployeeIdentification employeeIdentification){
        return employeeIdentificationRepository.updateEmployeeIdentification(employeeIdentification);
    }

}
