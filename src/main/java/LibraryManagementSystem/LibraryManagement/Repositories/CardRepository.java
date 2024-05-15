package LibraryManagementSystem.LibraryManagement.Repositories;

import LibraryManagementSystem.LibraryManagement.Model.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<LibraryCard,Integer> {

}
