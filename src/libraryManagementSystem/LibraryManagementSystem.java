package libraryManagementSystem;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class LibraryManagementSystem {
    private static LibraryManagementSystem instance;
    private final Catalog catalog;
    private final Map<String,Book> books;
    private Map<String,Member> members;
    private final Map<String,Loan> loans;

    public LibraryManagementSystem() {
        this.catalog = new Catalog();
        this.books = new ConcurrentHashMap<>();
        this.members = new ConcurrentHashMap<>();
        this.loans = new ConcurrentHashMap<>();
    }
    // singleton instance
    public static synchronized LibraryManagementSystem getInstance(){
        if(instance==null) return instance=new LibraryManagementSystem();
        return instance;
    }
    public Member registerMember(String name,String contactInfo)
    {
        Member member=new Member(name,contactInfo,new ArrayList<>());
        members.put(member.getId(),member);
        return member;
    }
    public BookCopy addBookCopy(String bookname,String title,String authorName)
    {
        Book book =books.getOrDefault(bookname,new Book(Integer.parseInt(bookname),bookname,authorName));
        books.put(bookname,book);
        BookCopy cop =new BookCopy(book);
        catalog.add(cop);
        return cop;
    }
    public synchronized boolean borrowBook(String memberId,String barCode) throws Exception {
        Member member=members.get(memberId);
        BookCopy bookCopy =catalog.getBookCopyByBarCode(barCode);
        if(member==null || bookCopy==null)
        {
            System.out.println("Error :invalid member or booookk");
            return false;
        }
        if(member.getBorrowedCount()>=10)
        {
            System.out.println("Erro member has reached browwing limit");
            return false;
        }
        bookCopy.markBorrowed();
        Loan loan =new Loan(bookCopy,member);
        member.addLoan(loan);
        loans.put(loan.getId().toString(),loan);
        System.out.printf("Sucessfully brrowed %s by % s",bookCopy.getBook().getBookId(),member.getName());
        return true;
    }



}
