package proj.crud.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.crud.library.entity.Loan;

import java.util.UUID;

public interface LoanRepository extends JpaRepository<Loan, UUID> {
}
