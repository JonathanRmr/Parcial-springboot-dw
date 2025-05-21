package com.api.crud.services;

import com.api.crud.models.LoanModel;
import com.api.crud.repositories.ILoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private ILoanRepository loanRepository;

    public LoanModel crearPrestamo(LoanModel prestamo) {
        prestamo.setDevuelto(false);
        return loanRepository.save(prestamo);
    }

    public List<LoanModel> listarTodos() {
        return loanRepository.findAll();
    }

    public List<LoanModel> prestamosPorUsuario(Long userId) {
        return loanRepository.findByUserId(userId);
    }

    public List<LoanModel> prestamosConRetardo() {
        return loanRepository.findByDevueltoFalseAndFechaDevolucionBefore(LocalDate.now());
    }

    public Optional<LoanModel> marcarDevuelto(Long id) {
        Optional<LoanModel> prestamo = loanRepository.findById(id);
        prestamo.ifPresent(p -> {
            p.setDevuelto(true);
            loanRepository.save(p);
        });
        return prestamo;
    }
}
