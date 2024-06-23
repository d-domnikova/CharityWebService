package edu.domnikova.CharityWebService.project;

import jakarta.validation.GroupSequence;
import jakarta.validation.groups.Default;

@GroupSequence({Default.class, ProjectValidationGroupOne.class, ProjectValidationGroupTwo.class})
public interface ProjectValidationGroupSequence {
}