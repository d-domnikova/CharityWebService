package edu.domnikova.CharityWebService.project;

import edu.domnikova.CharityWebService.project.projectEntity.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@NotExistingProject(groups = ProjectValidationGroupTwo.class)
public class CreateProjectFromData {
    @NotBlank
    @Size(min = 3, max = 150, groups = ProjectValidationGroupOne.class)
    private String title;
    @NotBlank
    @Size(min = 3, max = 150, groups = ProjectValidationGroupOne.class)
    private String firstName;
    @NotBlank
    @Size(min = 3, max = 150, groups = ProjectValidationGroupOne.class)
    private String lastName;
    @NotNull
    private Category category;
    private String city;
    @NotBlank
    @Size(min = 3, max = 150, groups = ProjectValidationGroupOne.class)
    private String country;
    @NotBlank(groups = ProjectValidationGroupOne.class)
    private String description;
    @NotBlank(groups = ProjectValidationGroupOne.class)
    private Double neededAmount;
    @NotBlank(groups = ProjectValidationGroupOne.class)
    private Double gatheredAmount;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
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
    public CreateProjectParameters projectParameters(){
        return new CreateProjectParameters(
                new Title(title),
                new User(firstName, lastName),
                category,
                new Location(city, country),
                new Description(description),
                neededAmount,
                gatheredAmount);
    }
}