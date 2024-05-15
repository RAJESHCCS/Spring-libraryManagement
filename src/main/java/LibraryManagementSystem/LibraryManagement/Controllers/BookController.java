package LibraryManagementSystem.LibraryManagement.Controllers;

import LibraryManagementSystem.LibraryManagement.Model.Book;
import LibraryManagementSystem.LibraryManagement.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookservice;
    @PostMapping("addbook")
    public String addBook(Book book){
       return bookservice.addBook(book);
    }
    @PutMapping("/associateBookAndAuthor")
   public ResponseEntity associateBookAndAuthor(@RequestParam("bookId") Integer bookId,
                                      @RequestParam("authorId") Integer authorId){
         try{
             String response = bookservice.associateBookAndCard(bookId,authorId);
             return new ResponseEntity(response, HttpStatus.OK);
         }
         catch (Exception e){
             return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
         }
    }
    }



