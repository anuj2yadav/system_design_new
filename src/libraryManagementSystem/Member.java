package libraryManagementSystem;
import java.util.*;
public class Member {
    private final String id;
    private final String name;
    private final String contactInfo;
    private final List<Loan> loans;

    public Member( String name, String contactInfo, List<Loan> loans) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.contactInfo = contactInfo;
        this.loans = loans;
    }

    public int getBorrowedCount(){
        return this.loans.size();
    }
    punlic synchronized void addLoan(Loan loan){
        this.loans.add(loan);
    }
    public List<Loan> getLoans(){
        return this.loans;
    }
    public String getId(){
        return this.id;
    }
    public String getName(){
        return name;
    }
    public boolean removeLoan(Loan loan)
    {
        this.loans.remove(loan);
    }
}
