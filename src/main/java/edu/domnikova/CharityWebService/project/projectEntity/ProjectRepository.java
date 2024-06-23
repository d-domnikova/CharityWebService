package edu.domnikova.CharityWebService.project.projectEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ProjectRepository extends CrudRepository<Project, ProjectId>,
                                            PagingAndSortingRepository<Project, ProjectId>, ProjectRepositoryCustom {
}