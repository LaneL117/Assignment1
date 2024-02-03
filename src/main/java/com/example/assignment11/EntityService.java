package com.example.assignment11;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntityService {

    private final List<EntityDTO> Entity = new ArrayList<>();
    private long nextId = 1;

    public List<EntityDTO> getAllEntity() {
        return new ArrayList<>(Entity);
    }

    public EntityDTO getEntityById(Long id) {
        return Entity.stream()
                .filter(Entity -> Entity.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public EntityDTO createEntity(EntityDTO EntityDTO) {
        EntityDTO.setId(nextId++);
        Entity.add(EntityDTO);
        return EntityDTO;
    }

    public EntityDTO updateEntity(Long id, EntityDTO updatedEntity) {
        for (EntityDTO Entity : Entity) {
            if (Entity.getId().equals(id)) {
                Entity.setName(updatedEntity.getName());
                return Entity;
            }
        }
        return null;
    }

    public void deleteEntity(Long id) {
        Entity.removeIf(Entity -> Entity.getId().equals(id));
    }
}