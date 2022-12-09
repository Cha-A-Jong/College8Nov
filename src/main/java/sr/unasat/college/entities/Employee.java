package sr.unasat.college.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long id;
    private String firstname;
    private String lastname;

    @OneToOne
    private EmployeeIdentification employeeIdentification;

    @ManyToOne
    private Department departmentID;

    @ManyToMany (cascade = {CascadeType.ALL})
    @JoinTable (name = "Employee_Project",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "project_id")})
    private List<Project> project;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public EmployeeIdentification getEmployeeIdentification() {
        return employeeIdentification;
    }

    public void setEmployeeIdentification(EmployeeIdentification employeeIdentification) {
        this.employeeIdentification = employeeIdentification;
    }

    public Department getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Department departmentID) {
        this.departmentID = departmentID;
    }

    public List<Project> getProject() {
        return project;
    }

    public void setProject(List<Project> project) {
        this.project = project;
    }
}
