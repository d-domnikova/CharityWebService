package edu.domnikova.CharityWebService.project.projectEntity;

import io.github.wimdeblauwe.jpearl.AbstractVersionedEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "tt_projects")
public class Project extends AbstractVersionedEntity<ProjectId> {
    @NotNull
    @Convert(converter = TitleAttributeConverter.class)
    private Title title;
    @NotNull
    private User createdBy;
    @Enumerated(EnumType.STRING)
    private Category category;
    @NotNull
    private Location location;
    @NotNull
    @Convert(converter = DescriptionAttributeConverter.class)
    private Description description;
    @NotNull
    private Double neededAmount;
    private Double gatheredAmount;

    protected Project() {
    }

    public Project(ProjectId id,
                   Title title,
                   User createdBy,
                   Category category,
                   Location location,
                   Description description,
                   Double neededAmount) {
        super(id);
        this.title = title;
        this.createdBy = createdBy;
        this.category = category;
        this.location = location;
        this.description = description;
        this.neededAmount = neededAmount;
        this.gatheredAmount = 0.0;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Category getCategory() {
        return Optional.ofNullable(category).orElse(Category.UNCATEGORIZED);
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Double getNeededAmount() {
        return neededAmount;
    }

    public void setNeededAmount(Double neededAmount) {
        this.neededAmount = neededAmount;
    }

    public Double getGatheredAmount() {
        return gatheredAmount;
    }

    public void setGatheredAmount(Double gatheredAmount) {
        this.gatheredAmount = gatheredAmount;
    }
}