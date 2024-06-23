package edu.domnikova.CharityWebService.project;

import edu.domnikova.CharityWebService.project.projectEntity.*;

public class EditProjectFromData extends CreateProjectFromData{
    private String id;
    private long version;
    public static EditProjectFromData editProjectFromData(Project project) {
        EditProjectFromData result = new EditProjectFromData();
        result.setId(project.getId().asString());
        result.setVersion(project.getVersion());
        result.setTitle(project.getTitle().asString());
        result.setFirstName(project.getCreatedBy().getFirstName());
        result.setLastName(project.getCreatedBy().getLastName());
        result.setCategory(project.getCategory());
        result.setCity(project.getLocation().getCity());
        result.setCountry(project.getLocation().getCountry());
        result.setDescription(project.getDescription().asString());
        result.setNeededAmount(project.getNeededAmount());
        result.setGatheredAmount(project.getGatheredAmount());
        return result;
    }

    public EditProjectParameters projectParameters() {
        return new EditProjectParameters(
                version, new Title(getTitle()), new User(getFirstName(), getLastName()),
                getCategory(), new Location(getCity(), getCountry()), new Description(getDescription()),
                getNeededAmount(), getGatheredAmount()
        );
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}