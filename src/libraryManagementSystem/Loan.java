package libraryManagementSystem;

import java.time.LocalDate;
import java.util.UUID;

public class Loan {
    public String loanId;
    private final BookCopy copy;
    private Member member;
    private final LocalDate borrowDate;
    private final LocalDate endDate;
    private boolean isActive =true;

    public Loan(LocalDate endDate, LocalDate borrowDate, Member member, BookCopy copy, String loanId) {
        this.endDate = endDate;
        this.borrowDate = borrowDate;
        this.member = member;
        this.copy = copy;
        this.loanId = UUID.randomUUID().toString();
    }

    private static final int max_borrow_days=14;

   public void closeLoan(){
       this.copy.markAvailable();
       this.isActive=false;
       member.removeLoan(this);
   }

    public String getId() {
       return this.loanId;

    }
}
