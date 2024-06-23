package edu.domnikova.CharityWebService.project.projectEntity;

public class EditProjectParameters extends CreateProjectParameters {
    private final long version;
    public EditProjectParameters(long version, Title title, User createdBy, Category category, Location location, Description description, Double neededAmount, Double gatheredAmount) {
        super(title, createdBy, category, location, description, neededAmount, gatheredAmount);
        this.version = version;
    }

    public long getVersion() {
        return version;
    }

    public void update(Project project){
        project.setTitle(getTitle());
        project.setCreatedBy(getCreatedBy());
        project.setCategory(getCategory());
        project.setLocation(getLocation());
        project.setDescription(getDescription());
        project.setNeededAmount(getNeededAmount());
        project.setGatheredAmount(getGatheredAmount());
    }
}