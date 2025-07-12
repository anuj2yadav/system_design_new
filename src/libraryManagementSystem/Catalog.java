package libraryManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Catalog {


    TreeMap<String, List<BookCopy>> bookByName;
    TreeMap<String,List<BookCopy>> bookByAuthor;
    TreeMap<String,List<BookCopy>> bookByTitle;

    Map<String,BookCopy> bookCopyByBarCode;
    public Catalog(){
        this.bookByName = new TreeMap<>();
        this.bookByAuthor = new TreeMap<>();
        this.bookByTitle = new TreeMap<>();
        this.bookCopyByBarCode = new TreeMap<>();
    }
    public Catalog(TreeMap<String, List<BookCopy>> bookByName, TreeMap<String, List<BookCopy>> bookByAuthor, TreeMap<String, List<BookCopy>> bookByTitle, Map<String, BookCopy> bookCopyByBarCode) {
        this.bookByName = bookByName;
        this.bookByAuthor = bookByAuthor;
        this.bookByTitle = bookByTitle;
        this.bookCopyByBarCode = bookCopyByBarCode;
    }
    public synchronized List<BookCopy> getBookByTitle(String title)
    {
        return bookByTitle.getOrDefault(title,new ArrayList<>());
    }

    public synchronized void add(BookCopy bookCopy)
    {
        Book book=bookCopy.getBook();
        bookByTitle.computeIfAbsent(book.getBookTitle().toLowerCase(),k-> new ArrayList<>()).add(bookCopy);
        bookByAuthor.computeIfAbsent(book.getAuthorName().toLowerCase(),k->new ArrayList<>()).add(bookCopy);
        //validation can be added if book already exist or not
        bookCopyByBarCode.put(bookCopy.getBarCode(),bookCopy);
    }
    public BookCopy getBookCopyByBarCode(String barCode) throws Exception {
        // you can create a custom exception to be thrown and hanlde in advice
        if(!bookCopyByBarCode.containsKey(barCode)) throw new Exception("Book with given with barcode doesn't exist");
        return bookCopyByBarCode.get(barCode);
    }
    public synchronized List<Book> searchByTitle(String title)
    {

        return bookByTitle.getOrDefault(title,new ArrayList<>()).stream().map(item->item.getBook())
                .distinct().collect(Collectors.toList());
    }
    public synchronized List<Book> getBookByAuthor(String author)
    {
        return bookByAuthor.getOrDefault(author,new ArrayList<>()).stream().
                map(item->item.getBook()).distinct().collect(Collectors.toList());

    }
//    public BookCopy getB



}
