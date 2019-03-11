package efeeney.test.library.controllers;

import efeeney.test.library.entity.Book;
import efeeney.test.library.repository.BookRepository;
import efeeney.test.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {
	private BookService bookService;
	private BookRepository bookRepository;

	@Autowired
	public BookController(BookService bookService, BookRepository bookRepository) {
		this.bookService = bookService;
		this.bookRepository = bookRepository;
	}

	@GetMapping("/")
	public String list(Model model) {
		List<Book> books= bookRepository.findAllByOrderByIdAsc();
		model.addAttribute("books", books);
		return "index";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Book book = bookService.getBookById(id);
		model.addAttribute("book", book);
		return "operations/edit";
	}

	@PostMapping("/update")
	public String saveBook(@RequestParam Integer id, @RequestParam String name, @RequestParam String author, @RequestParam String genre, @RequestParam String description) {
		bookService.updateBook(id, name, author, genre, description);
		return "redirect:/";
	}

	@GetMapping("/new")
	public String newBook() {return "operations/new";}

	@PostMapping("/save")
	public String updateBook(@RequestParam String name, @RequestParam String author, @RequestParam String genre, @RequestParam String description) {
		bookService.saveBook(new Book(name, author, genre, description));
		return "redirect:/";
	}

}
