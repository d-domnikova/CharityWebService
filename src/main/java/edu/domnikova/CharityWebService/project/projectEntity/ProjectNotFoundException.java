package edu.domnikova.CharityWebService.project.projectEntity;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(ProjectId projectId) {
        super(String.format("Project with ID %s not found.", projectId.asString()));
    }
}