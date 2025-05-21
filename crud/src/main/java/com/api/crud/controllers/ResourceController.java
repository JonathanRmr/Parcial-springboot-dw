package com.api.crud.controllers;

import com.api.crud.models.ResourceModel;
import com.api.crud.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
@CrossOrigin(origins = "*")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @PostMapping
    public ResponseEntity<ResourceModel> crearRecurso(@RequestBody ResourceModel recurso) {
        return ResponseEntity.ok(resourceService.crearRecurso(recurso));
    }

    @GetMapping
    public ResponseEntity<List<ResourceModel>> obtenerTodos() {
        return ResponseEntity.ok(resourceService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
        return resourceService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody ResourceModel nuevo) {
        return resourceService.actualizarRecurso(id, nuevo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        return resourceService.eliminarPorId(id)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }
}
