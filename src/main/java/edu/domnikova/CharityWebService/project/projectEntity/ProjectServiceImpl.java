package edu.domnikova.CharityWebService.project.projectEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.shaded.com.google.common.collect.ImmutableSet;

import java.util.Optional;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService{
    private final ProjectRepository repository;

    public ProjectServiceImpl(ProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public Project createProject(CreateProjectParameters parameters) {
        ProjectId projectId = repository.nextId();
        Project project = new Project(projectId,
                parameters.getTitle(),
                parameters.getCreatedBy(),
                parameters.getCategory(),
                parameters.getLocation(),
                parameters.getDescription(),
                parameters.getNeededAmount(),
                parameters.getGatheredAmount());
        return repository.save(project);
    }

    @Override
    public Page<Project> getProjects(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Project> getProject(ProjectId projectId) {
        return repository.findById(projectId);
    }

    @Override
    public ImmutableSet<Project> getAllProject() {
        return null;
    }

    @Override
    public boolean ProjectWithTitleExist(Title title) {
        return repository.existsByTitle(title);
    }

    @Override
    public Project editProject(ProjectId projectId, EditProjectParameters editProjectParameters) {
        var project = repository
                .findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException(projectId));
        if (editProjectParameters.getVersion() != project.getVersion()) {
            throw new ObjectOptimisticLockingFailureException(Project.class, project.getId().asString());
        }
        editProjectParameters.update(project);
        return project;
    }

    @Override
    public void deleteProject(ProjectId projectId) {
        repository.deleteById(projectId);
    }
}