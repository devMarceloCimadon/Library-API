package proj.crud.library.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proj.crud.library.dto.loan.CreateLoanDto;
import proj.crud.library.dto.loan.UpdateLoanDto;
import proj.crud.library.entity.Loan;
import proj.crud.library.service.LoanService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
    private LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestBody CreateLoanDto createLoanDto){
        var loanId = loanService.createLoan(createLoanDto);
        return ResponseEntity.created(URI.create("/api/loans" + loanId.toString())).build();
    }

    @GetMapping("/{loanId}")
    public ResponseEntity<Loan> getLoanById(@PathVariable("loanId") String loanId){
        var loan = loanService.getLoanById(loanId);
        return loan.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Loan>> listLoan(){
        var loans = loanService.listLoans();
        return ResponseEntity.ok(loans);
    }

    @PutMapping("/{loanId}")
    public ResponseEntity<Loan> updateLoanById(@PathVariable("loanId") String loanId, UpdateLoanDto updateLoanDto){
        loanService.updateLoanById(loanId, updateLoanDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{loanId}")
    public ResponseEntity<Void> deleteLoanById(@PathVariable("loanId") String loanId){
        loanService.deleteLoanById(loanId);
        return ResponseEntity.ok().build();
    }
}
