package edu.domnikova.CharityWebService.project.projectEntity;

import io.github.wimdeblauwe.jpearl.AbstractEntityId;

import java.util.UUID;

public class ProjectId extends AbstractEntityId<UUID> {

   /**
   * Default constructor for JPA
   */
   protected ProjectId() {
   }

   public ProjectId(UUID id) {
       super(id);
   }
}