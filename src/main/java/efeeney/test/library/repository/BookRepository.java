package efeeney.test.library.repository;

import efeeney.test.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
	List<Book> findAllByOrderByIdAsc();
}
