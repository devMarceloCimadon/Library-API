package proj.crud.library.service;

import org.springframework.stereotype.Service;
import proj.crud.library.dto.book.UpdateBookDto;
import proj.crud.library.dto.loan.CreateLoanDto;
import proj.crud.library.dto.loan.UpdateLoanDto;
import proj.crud.library.entity.Loan;
import proj.crud.library.repository.LoanRepository;

import java.util.*;

@Service
public class LoanService {
    private LoanRepository loanRepository;
    private BookService bookService;

    public LoanService(LoanRepository loanRepository, BookService bookService) {
        this.loanRepository = loanRepository;
        this.bookService = bookService;
    }

    public UUID createLoan(CreateLoanDto createLoanDto){
        Date loanDate = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(loanDate);
        calendar.add(Calendar.DAY_OF_YEAR, 7);

        Date expectedReturnDate = calendar.getTime();

        var entity = new Loan(UUID.randomUUID(), createLoanDto.userId(), createLoanDto.bookId(), loanDate, expectedReturnDate, null);
        var loanSaved = loanRepository.save(entity);
        bookService.updateBookById(createLoanDto.bookId(), new UpdateBookDto(false));
        return loanSaved.getLoanId();
    }

    public Optional<Loan> getLoanById(String loanId){
        return loanRepository.findById(UUID.fromString(loanId));
    }

    public List<Loan> listLoans(){
        return loanRepository.findAll();
    }

    public void updateLoanById(String loanId, UpdateLoanDto updateLoanDto){
        var id = UUID.fromString(loanId);
        var loanEntity = loanRepository.findById(id);
        if(loanEntity.isPresent()){
            var loan = loanEntity.get();
            loan.setReturnDate(new Date());
            bookService.updateBookById(loan.getBookId(), new UpdateBookDto(true));

            loanRepository.save(loan);
        }
    }

    public void deleteLoanById(String loanId){
        var id = UUID.fromString(loanId);
        var loanExists = loanRepository.existsById(id);
        if(loanExists){
            loanRepository.deleteById(id);
        }
    }
}
