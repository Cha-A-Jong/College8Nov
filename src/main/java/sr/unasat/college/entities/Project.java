package sr.unasat.college.entities;

import jakarta.persistence.*;

import java.util.List;

//any given employee can be assigned to multiple projects and a project may have multiple employees working for it.

@Entity
public class Project {

    @Id
    @GeneratedValue
    private Long id;
    private String title;

    @ManyToMany (cascade = {CascadeType.ALL})
    @JoinTable (name = "Employee_Project",
            joinColumns = {@JoinColumn(name = "project_id")},
            inverseJoinColumns = {@JoinColumn(name = "employee_id")})
    private List<Employee> employee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }
}
