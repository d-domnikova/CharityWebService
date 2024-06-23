package edu.domnikova.CharityWebService.project.projectEntity;

import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StringToProjectIdConverter implements Converter<String, ProjectId> {
    @Override
    public ProjectId convert(@NotNull String source) {
        return new ProjectId(UUID.fromString(source));
    }
}