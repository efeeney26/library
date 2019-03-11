package efeeney.test.library.service;

import efeeney.test.library.entity.Book;
import efeeney.test.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService{

	private BookRepository bookRepository;

    @Autowired
	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}


	@Override
	public Book getBookById(Integer id) {
		return bookRepository.getOne(id);
	}

	@Override
	public void saveBook(Book book) {
		bookRepository.save(book);
	}

	@Override
	public void updateBook(Integer id, String name, String author, String genre, String description) {
		Book updated = getBookById(id);
		updated.setName(name);
		updated.setAuthor(author);
		updated.setGenre(genre);
		updated.setDescription(description);
		saveBook(updated);
	}

	@Override
	public List<Book> findAllByOrderByDateAsc() {
		return bookRepository.findAllByOrderByIdAsc();
	}
}
