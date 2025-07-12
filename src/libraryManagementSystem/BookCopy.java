package libraryManagementSystem;

import java.util.UUID;

public class BookCopy {
    public String getBarCode() {
        return barCode;
    }

    public Book getBook() {
        return book;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    private final String barCode;
    private final Book book;
    private BookStatus status;

    public BookCopy(Book book)
    {
        this.barCode= UUID.randomUUID().toString();
        this.book=book;
        this.status=BookStatus.AVAILABLE;
    }
    public synchronized  boolean isAvailable(){
        return this.status==BookStatus.AVAILABLE;
    }
    public synchronized void markBorrowed()
    {
        if(!isAvailable()) throw new IllegalStateException("Book is not Available");
        this.status=BookStatus.AVAILABLE;

    }
    public synchronized  void markAvailable()
    {
        this.status=BookStatus.AVAILABLE;
    }
}
