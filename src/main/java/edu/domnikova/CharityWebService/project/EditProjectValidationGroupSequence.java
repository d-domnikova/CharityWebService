package edu.domnikova.CharityWebService.project;

import jakarta.validation.GroupSequence;
import jakarta.validation.groups.Default;

@GroupSequence({Default.class, ProjectValidationGroupOne.class})
public interface EditProjectValidationGroupSequence {
}
