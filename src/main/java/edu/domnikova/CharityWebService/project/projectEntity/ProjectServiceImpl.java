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
}