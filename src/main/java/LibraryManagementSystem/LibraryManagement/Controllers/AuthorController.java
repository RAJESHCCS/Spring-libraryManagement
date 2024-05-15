package LibraryManagementSystem.LibraryManagement.Controllers;


import LibraryManagementSystem.LibraryManagement.Model.Author;
import LibraryManagementSystem.LibraryManagement.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("author")
public class AuthorController {


    @Autowired
    private AuthorService authorservice;
    @PostMapping("add")
    public String addAuthor(@RequestBody Author author){
        return authorservice.addService(author);
    }
    @GetMapping("findAuthorById")
    public ResponseEntity findAuthorById(@RequestParam("id") Integer authorId){
        try{
            Author authorResponse = authorservice.findAuthorById(authorId);
            return new ResponseEntity(authorResponse, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
    }

}}