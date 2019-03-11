package efeeney.test.library.service;

import efeeney.test.library.entity.Book;

import java.util.List;

public interface BookService {
    Book getBookById(Integer id);
    void saveBook(Book book);
    void updateBook(Integer id, String name, String author, String genre, String description);
    List<Book> findAllByOrderByDateAsc();
}
