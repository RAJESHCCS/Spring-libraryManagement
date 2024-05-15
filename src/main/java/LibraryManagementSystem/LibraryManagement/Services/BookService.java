package LibraryManagementSystem.LibraryManagement.Services;

import java.util.Optional;

import LibraryManagementSystem.LibraryManagement.Model.Author;
import LibraryManagementSystem.LibraryManagement.Model.Book;
import LibraryManagementSystem.LibraryManagement.Repositories.AuthorRepository;
import LibraryManagementSystem.LibraryManagement.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookrepository;
    @Autowired
    private AuthorRepository authorrepository;


    public String addBook(Book book){

        book = bookrepository.save(book);
        return "book data has been saved in db with book id"+book.getBookId();
    }
//    public String associateBookAndCard(Integer bookId, Integer authorId) throws Exception{
//        Optional<Book> OptionalBook = bookrepository.findById(bookId);
//        if(OptionalBook.isEmpty()){
//            throw new Exception("entered bookId is invalid");
//        }
//        Optional<Author> OptionalAuthor = authorrepository.findById(authorId);
//
//        if(OptionalAuthor.isEmpty()) {
//            throw new Exception("Entered AuthorId is invalid");
//        }
//        Book book  = OptionalBook.get();
//        Author author = OptionalAuthor.get();
//
//        book.setAuthor(author);
//        author.setNoOfBooks(author.getNoOfBooks()+1);
//
//        bookrepository.save(book);
//        authorrepository.save(author);
//
//        return "book and author have been associated";
//    }

    public String associateBookAndCard(Integer bookId,Integer authorId) throws Exception{

        Optional<Book> optionalBook = bookrepository.findById(bookId);

        if(optionalBook.isEmpty()) {
            throw new Exception("Entered bookId is invalid");
        }

        Optional<Author> optionalAuthor = authorrepository.findById(authorId);

        if(optionalAuthor.isEmpty()) {
            throw new Exception("Entered AuthorId is invalid");
        }

        Book book = optionalBook.get();
        Author author = optionalAuthor.get();

        book.setAuthor(author);
        author.setNoOfBooks(author.getNoOfBooks()+1);

        bookrepository.save(book);
        authorrepository.save(author);

        return "Book and author have been associated";
    }
}
