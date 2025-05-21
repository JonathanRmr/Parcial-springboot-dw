package com.api.crud.repositories;

import com.api.crud.models.LoanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ILoanRepository extends JpaRepository<LoanModel, Long> {
    List<LoanModel> findByDevueltoFalseAndFechaDevolucionBefore(LocalDate fechaLimite);
    List<LoanModel> findByUserId(Long userId);
}
