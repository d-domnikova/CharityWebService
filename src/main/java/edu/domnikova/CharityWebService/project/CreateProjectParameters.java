package edu.domnikova.CharityWebService.project;
public class CreateProjectParameters {
    private final Title title;
    private final User createdBy;
    private final Category category;
    private final Location location;
    private final Description description;
    private final Double neededAmount;
    private final Double gatheredAmount;

    public CreateProjectParameters(Title title, User createdBy, Category category, Location location, Description description, Double neededAmount, Double gatheredAmount) {
        this.title = title;
        this.createdBy = createdBy;
        this.category = category;
        this.location = location;
        this.description = description;
        this.neededAmount = neededAmount;
        this.gatheredAmount = gatheredAmount;
    }

    public Title getTitle() {
        return title;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public Category getCategory() {
        return category;
    }

    public Location getLocation() {
        return location;
    }

    public Description getDescription() {
        return description;
    }

    public Double getNeededAmount() {
        return neededAmount;
    }

    public Double getGatheredAmount() {
        return gatheredAmount;
    }
}