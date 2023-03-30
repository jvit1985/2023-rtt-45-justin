package springexamples.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import springexamples.database.entity.Employee;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeDAO extends JpaRepository<Employee, Long> {

    @Query("FROM Employee e")
    List<Employee> getAllEmployees();

    Employee findById(Integer id);

    List<Employee> findByFirstNameContainingOrLastNameContainingIgnoreCase(String firstName, String lastName);

    List<Employee> findByFirstNameContainingIgnoreCase(String firstName);

    List<Employee> findByLastNameContainingIgnoreCase(String lastName);

//    List<Employee> findByLastNameContainingIgnoreCase(String lastName);

//    @Query(value="SELECT * FROM employees WHERE firstname LIKE %:firstName% OR lastname LIKE %:lastName% ;", nativeQuery = true)
//    List<Employee> usingNativeQuery(String firstName, String lastName);

//    @Query("Select e from Employee e where e.firstName LIKE %:firstName% OR e.lastName LIKE %:lastName% ")
//    List<Employee> usingJPAQuery(String firstName, String lastName);
}

//write a real query to do the search by last name or first name like "search paramater" ignoring case