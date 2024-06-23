package edu.domnikova.CharityWebService.project.projectEntity;

import jakarta.persistence.Embeddable;
import org.springframework.util.Assert;
import org.testcontainers.shaded.com.google.common.base.MoreObjects;

import java.util.Objects;

@Embeddable
public class Location {
    private String city;
    private String country;

    protected Location(){
    }

    public Location(String city, String country) {
        Assert.hasText(country, "Country cannot be blank");
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
    public String getFullLocation() {
        return String.format("%s %s", city, country);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Location location = (Location) o;
        return Objects.equals(city, location.city) &&
                Objects.equals(country, location.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("city", city)
                .add("country", country)
                .toString();
    }
}