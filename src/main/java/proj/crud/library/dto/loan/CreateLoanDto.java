package proj.crud.library.dto.loan;

import java.util.Date;

public record CreateLoanDto(String userId, String bookId, Date loanDate, Date expectedReturnDate, Date returnDate) {
}
