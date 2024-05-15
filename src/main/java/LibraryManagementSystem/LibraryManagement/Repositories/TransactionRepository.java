package LibraryManagementSystem.LibraryManagement.Repositories;

import LibraryManagementSystem.LibraryManagement.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {


}
