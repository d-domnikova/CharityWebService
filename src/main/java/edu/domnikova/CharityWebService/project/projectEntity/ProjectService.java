package edu.domnikova.CharityWebService.project.projectEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.testcontainers.shaded.com.google.common.collect.ImmutableSet;

import java.util.Optional;

public interface ProjectService {
    Project createProject(CreateProjectParameters parameters);
    Page<Project> getProjects(Pageable pageable);
}