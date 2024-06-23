package edu.domnikova.CharityWebService.project.projectEntity;

import jakarta.persistence.Embeddable;
import org.springframework.util.Assert;
import org.testcontainers.shaded.com.google.common.base.MoreObjects;

import java.util.Objects;

@Embeddable
public class User {
    private String firstName;
    private String lastName;

    protected User() {
    }

    public User(String firstName, String lastName) {
        Assert.hasText(firstName, "First name cannot be blank");
        Assert.hasText(lastName, "Last name cannot be blank");
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User userName = (User) o;
        return Objects.equals(firstName, userName.firstName) &&
                Objects.equals(lastName, userName.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("firstName", firstName)
                .add("lastName", lastName)
                .toString();
    }
}
