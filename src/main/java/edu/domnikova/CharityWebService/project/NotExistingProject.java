package edu.domnikova.CharityWebService.project;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotExistingProjectValidator.class)
public @interface NotExistingProject {

    String message() default "{ProjectAlreadyExisting}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
