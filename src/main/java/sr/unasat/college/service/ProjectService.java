package sr.unasat.college.service;

import sr.unasat.college.configuration.JPAConfig;
import sr.unasat.college.entities.Project;
import sr.unasat.college.repository.ProjectRepository;

import java.util.List;

public class ProjectService {

   private final ProjectRepository repository;

   public ProjectService(){this.repository = new ProjectRepository(JPAConfig.getEntityManager());}

    public List<Project> getProject(){ return repository.getProject();}

    public Project createProject(Project project){
       return repository.createProject(project);
    }

    public Project deleteProject(Project project){
       return repository.deleteProject(project);
    }

    public Project updateProject(Project project){
       return repository.updateProject(project);
    }

}
