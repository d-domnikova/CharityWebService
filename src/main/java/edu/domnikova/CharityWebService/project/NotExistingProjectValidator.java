package edu.domnikova.CharityWebService.project;

import edu.domnikova.CharityWebService.project.projectEntity.ProjectService;
import edu.domnikova.CharityWebService.project.projectEntity.Title;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class NotExistingProjectValidator implements ConstraintValidator<NotExistingProject, CreateProjectFromData> {

    private final ProjectService service;

    @Autowired
    public NotExistingProjectValidator(ProjectService service) {
        this.service = service;
    }

    @Override
    public void initialize(NotExistingProject constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(CreateProjectFromData formData, ConstraintValidatorContext context) {
        if (service.ProjectWithTitleExist(new Title(formData.getTitle()))) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("{ProjectAlreadyExisting}")
                    .addPropertyNode("title").addConstraintViolation();
            return false;
        }
        return true;
    }
}
