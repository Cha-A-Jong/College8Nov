package sr.unasat.college.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import sr.unasat.college.entities.Department;
import sr.unasat.college.entities.Project;

import java.util.List;

public class ProjectRepository {

    private EntityManager entityManager;

    public ProjectRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Project> getProject() {
        String query = "select p from Project p";
        TypedQuery<Project> typedQuery = entityManager.createQuery(query, Project.class);
        List<Project> projectList = typedQuery.getResultList();
        return projectList;
    }

    public Project createProject(Project project) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(project);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return project;
    }

    public Project deleteProject(Project project) {
        try {
            entityManager.getTransaction().begin();
            entityManager.find(Project.class, project.getId());
            if (project != null) entityManager.remove(project);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return project;
    }


    public Project updateProject(Project project) {
        try {
            entityManager.getTransaction().begin();
/*            String findQuery = "from Person where id = :person_id";
            Query query = entityManager.createQuery(findQuery);
            query.setParameter("person_id", person.getId());*/
            entityManager.find(Project.class, project.getId());
            entityManager.merge(project);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return project;
    }
}
