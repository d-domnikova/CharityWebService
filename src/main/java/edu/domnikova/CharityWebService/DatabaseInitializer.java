package edu.domnikova.CharityWebService;

import com.github.javafaker.Faker;
import edu.domnikova.CharityWebService.project.projectEntity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("init-db")
public class DatabaseInitializer implements CommandLineRunner {
    private final Faker faker = new Faker();
    private final ProjectService projectService;

    public DatabaseInitializer(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public void run(String... args) {
        for (int i = 0; i < 15; i++) {
            CreateProjectParameters parameters = newRandomProjectParameters();
            projectService.createProject(parameters);
        }
    }

    private CreateProjectParameters newRandomProjectParameters() {

        Title title = new Title(faker.lorem().sentence());
        User createdBy = new User(faker.name().firstName(), faker.name().lastName());
        Category category = faker.options().option(Category.class);
        Location location = new Location(faker.address().city(), faker.address().country());
        Description description = new Description(faker.lorem().paragraph());
        Double neededAmount = faker.number().randomDouble(2, 10000, 50000);
        Double gatheredAmount = faker.number().randomDouble(2, 0, 4000);

        return new CreateProjectParameters(title, createdBy, category, location, description, neededAmount, gatheredAmount);
    }
}