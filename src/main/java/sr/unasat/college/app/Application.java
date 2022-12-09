package sr.unasat.college.app;

import sr.unasat.college.entities.Employee;
import sr.unasat.college.entities.EmployeeIdentification;
import sr.unasat.college.service.EmployeeService;
import sr.unasat.college.service.EmployeeIdentificationService;


public class Application {
    public static void main(String[] args) {

//        EntityManager entityManager = JPAConfig.getEntityManager();
//        JPAConfig.shutdown();

        EmployeeService employeeService = new EmployeeService();
        EmployeeIdentificationService employeeIdentificationService = new EmployeeIdentificationService();

        EmployeeIdentification employeeIdentification = new EmployeeIdentification();
        employeeIdentification.setAge(25);
        employeeIdentification.setWeight(65);

        EmployeeIdentification identification = employeeIdentificationService.createEmployeeIdentification(employeeIdentification);

        EmployeeIdentificationService employeeIdentificationService1 = new EmployeeIdentificationService();

        EmployeeIdentification employeeIdentification1 = new EmployeeIdentification();
        employeeIdentification1.setAge(30);
        employeeIdentification1.setWeight(70);

        EmployeeIdentification identification1 = employeeIdentificationService1.createEmployeeIdentification(employeeIdentification1);

        Employee createEmployee = new Employee();
        createEmployee.setFirstname("Chanella");
        createEmployee.setLastname("Wirjo");
        createEmployee.setEmployeeIdentification(identification);

        employeeService.createEmployee(createEmployee);

        Employee createEmployee1 = new Employee();
        createEmployee1.setFirstname("Sheldon");
        createEmployee1.setLastname("Coop");
        createEmployee1.setEmployeeIdentification(identification1);

        employeeService.createEmployee(createEmployee1);

//          List<Employee> employees = employeeService.getEmployees();
//        employees.forEach( employees1 -> {
//            System.out.println("Firstname = " + employees1.getFirstname() + "Lastname = " + employees1.getLastname());
//        });

    }
}
