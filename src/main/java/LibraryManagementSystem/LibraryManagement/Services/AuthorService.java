package LibraryManagementSystem.LibraryManagement.Services;


import LibraryManagementSystem.LibraryManagement.Model.Author;
import LibraryManagementSystem.LibraryManagement.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;


    public String addService(Author author){
        author =  authorRepository.save(author);
        return "Author repositor has been saved in db with author id"+author.getAuthorId();
    }
    public Author findAuthorById(Integer authorId) throws Exception{
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);

        if(optionalAuthor.isEmpty()){
            throw new Exception("invalid authorId entered");
        }
        Author author = optionalAuthor.get();
        return author;
    }
}
