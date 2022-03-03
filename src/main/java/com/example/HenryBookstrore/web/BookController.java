package com.example.HenryBookstrore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.HenryBookstrore.domain.Book;
import com.example.HenryBookstrore.domain.BookRepository;
import com.example.HenryBookstrore.domain.CategoryRepository;


@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
//listaa
	@RequestMapping(value = { "/", "/booklist" })
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
//lisää kirja
	@RequestMapping(value = "/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addbook";
	}
//tallentaa
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
//delete
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}
//edittaus
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
		model.addAttribute("categories", crepository.findAll());
		return "editBook.html";
	}
}
