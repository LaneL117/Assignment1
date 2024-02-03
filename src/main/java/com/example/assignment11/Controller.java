package com.example.assignment11;
import com.example.assignment11.EntityDTO;
import com.example.assignment11.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//Import Statements
import java.util.List;
//Controller code for the API
@RestController
@RequestMapping("/api/Entity")
public class Controller {

    @Autowired
    private EntityService entityService;

    @GetMapping
    public List<EntityDTO> getAllEntity() {
        return entityService.getAllEntity();
    }

    @GetMapping("/{id}")
    public EntityDTO getEntityById(@PathVariable Long id) {
        return entityService.getEntityById(id);
    }

    @PostMapping
    public EntityDTO createEntity(@RequestBody EntityDTO EntityDTO) {
        return entityService.createEntity(EntityDTO);
    }

    @PutMapping("/{id}")
    public EntityDTO updateEntity(@PathVariable Long id, @RequestBody EntityDTO updatedEntity) {
        return entityService.updateEntity(id, updatedEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteEntity(@PathVariable Long id) {
        entityService.deleteEntity(id);
    }
}