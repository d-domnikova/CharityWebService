package edu.domnikova.CharityWebService.project;

import org.springframework.util.Assert;
import org.testcontainers.shaded.com.google.common.base.MoreObjects;

import java.util.Objects;

public class Description {
    private String description;
    protected Description(){}

    public Description(String description) {
        Assert.hasText(description, "Description cannot be blank.");
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("description", description)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Description otherDescription = (Description) o;
        return Objects.equals(description, otherDescription.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }

    public String asString() {
        return description;
    }
}