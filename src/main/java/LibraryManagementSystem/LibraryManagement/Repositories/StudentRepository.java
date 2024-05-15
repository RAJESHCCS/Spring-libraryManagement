package LibraryManagementSystem.LibraryManagement.Repositories;

import LibraryManagementSystem.LibraryManagement.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
