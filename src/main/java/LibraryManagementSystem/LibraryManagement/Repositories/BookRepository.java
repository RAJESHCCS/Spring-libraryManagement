package LibraryManagementSystem.LibraryManagement.Repositories;

import LibraryManagementSystem.LibraryManagement.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {

}
