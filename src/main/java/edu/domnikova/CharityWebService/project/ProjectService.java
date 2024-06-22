package edu.domnikova.CharityWebService.project;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectService {
    Project createProject(CreateProjectParameters parameters);
    Page<Project> getBooks(Pageable pageable);
}