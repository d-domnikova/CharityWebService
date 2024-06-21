package edu.domnikova.CharityWebService.project;

import io.github.wimdeblauwe.jpearl.InMemoryUniqueIdGenerator;
import io.github.wimdeblauwe.jpearl.UniqueIdGenerator;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("data-jpa-test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProjectRepositoryTest {
    private final ProjectRepository repository;
    private final JdbcTemplate jdbcTemplate;
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    ProjectRepositoryTest(ProjectRepository repository,
                           JdbcTemplate jdbcTemplate) {
        this.repository = repository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @BeforeEach
    void validatePreconditions() {
        assertThat(repository.count()).isZero();
    }

    @Test
    void testSaveProject() {
        ProjectId id = repository.nextId();
        repository.save(new Project(id,
                new Title("Charity Service"),
                new User("Daria", "Domnikova"),
                Category.HEALTHCARE,
                new Location("", "Ukraine"),
                new Description("Test project for ProjectRepositoryTest"),
                10000.0,
                0.0));

        entityManager.flush();

        assertThat(jdbcTemplate.queryForObject("SELECT id FROM tt_projects", UUID.class)).isEqualTo(id.getId());
        assertThat(jdbcTemplate.queryForObject("SELECT title FROM tt_projects", String.class)).isEqualTo("Charity Service");
        assertThat(jdbcTemplate.queryForObject("SELECT first_name FROM tt_projects", String.class)).isEqualTo("Daria");
        assertThat(jdbcTemplate.queryForObject("SELECT last_name FROM tt_projects", String.class)).isEqualTo("Domnikova");
        assertThat(jdbcTemplate.queryForObject("SELECT category FROM tt_projects", Category.class)).isEqualTo(Category.HEALTHCARE);
        assertThat(jdbcTemplate.queryForObject("SELECT city FROM tt_projects", String.class)).isEqualTo("");
        assertThat(jdbcTemplate.queryForObject("SELECT country FROM tt_projects", String.class)).isEqualTo("Ukraine");
        assertThat(jdbcTemplate.queryForObject("SELECT description FROM tt_projects", String.class)).isEqualTo("Test project for ProjectRepositoryTest");
        assertThat(jdbcTemplate.queryForObject("SELECT needed_amount FROM tt_projects", Double.class)).isEqualTo(10000.0);
        assertThat(jdbcTemplate.queryForObject("SELECT gathered_amount FROM tt_projects", Double.class)).isEqualTo(0.0);

        entityManager.flush();

        UUID idInDb = jdbcTemplate.queryForObject("SELECT id FROM tt_projects", UUID.class);
        assertThat(idInDb).isEqualTo(id.getId());
    }

    @TestConfiguration
    static class TestConfig {
        @Bean
        public UniqueIdGenerator<UUID> uniqueIdGenerator() {
            return new InMemoryUniqueIdGenerator();
        }
    }
}