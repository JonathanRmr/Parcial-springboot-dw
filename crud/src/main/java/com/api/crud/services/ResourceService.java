package com.api.crud.services;

import com.api.crud.models.ResourceModel;
import com.api.crud.repositories.IResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {

    @Autowired
    private IResourceRepository resourceRepository;

    public ResourceModel crearRecurso(ResourceModel recurso) {
        return resourceRepository.save(recurso);
    }

    public List<ResourceModel> listarTodos() {
        return resourceRepository.findAll();
    }

    public Optional<ResourceModel> buscarPorId(Long id) {
        return resourceRepository.findById(id);
    }

    public boolean eliminarPorId(Long id) {
        if (resourceRepository.existsById(id)) {
            resourceRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<ResourceModel> actualizarRecurso(Long id, ResourceModel nuevo) {
        return resourceRepository.findById(id).map(recurso -> {
            recurso.setTitulo(nuevo.getTitulo());
            recurso.setTipo(nuevo.getTipo());
            recurso.setAutor(nuevo.getAutor());
            recurso.setAnioPublicacion(nuevo.getAnioPublicacion());
            return resourceRepository.save(recurso);
        });
    }
}
