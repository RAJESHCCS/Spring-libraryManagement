package LibraryManagementSystem.LibraryManagement.Repositories;

import LibraryManagementSystem.LibraryManagement.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorRepository extends JpaRepository<Author,Integer> {

}

