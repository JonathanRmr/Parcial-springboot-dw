package com.api.crud.controllers;

import com.api.crud.models.LoanModel;
import com.api.crud.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
@CrossOrigin(origins = "*")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping
    public ResponseEntity<LoanModel> crearPrestamo(@RequestBody LoanModel prestamo) {
        return ResponseEntity.ok(loanService.crearPrestamo(prestamo));
    }

    @GetMapping
    public ResponseEntity<List<LoanModel>> obtenerTodos() {
        return ResponseEntity.ok(loanService.listarTodos());
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<LoanModel>> prestamosUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(loanService.prestamosPorUsuario(id));
    }

    @GetMapping("/retardos")
    public ResponseEntity<List<LoanModel>> prestamosConRetardo() {
        return ResponseEntity.ok(loanService.prestamosConRetardo());
    }

    @PutMapping("/{id}/devolver")
    public ResponseEntity<?> marcarDevuelto(@PathVariable Long id) {
        return loanService.marcarDevuelto(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
