package edu.domnikova.CharityWebService.project;

import io.github.wimdeblauwe.jpearl.UniqueIdGenerator;

import java.util.UUID;

public class ProjectRepositoryImpl implements ProjectRepositoryCustom {
    private final UniqueIdGenerator<UUID> generator;

    public ProjectRepositoryImpl(UniqueIdGenerator<UUID> generator) {
        this.generator = generator;
    }

    @Override
    public ProjectId nextId() {
        return new ProjectId(generator.getNextUniqueId());
    }
}