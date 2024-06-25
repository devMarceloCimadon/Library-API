package proj.crud.library.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID loanId;

    @Column(name = "user_id")
    private String userId;
    @Column(name = "book_id")
    private String bookId;

    @Column(name = "loan_date")
    private Date loanDate;
    @Column(name = "expected_return_date")
    private Date expectedReturnDate;
    @Column(name = "return_date")
    private Date returnDate;

    public Loan() {
    }

    public Loan(UUID loanId, String userId, String bookId, Date loanDate, Date expectedReturnDate, Date returnDate) {
        this.loanId = loanId;
        this.userId = userId;
        this.bookId = bookId;
        this.loanDate = loanDate;
        this.expectedReturnDate = expectedReturnDate;
        this.returnDate = returnDate;
    }
}
