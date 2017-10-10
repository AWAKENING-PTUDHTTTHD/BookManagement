package com.awakening.bookManagement.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.awakening.bookManagement.model.Book;
import com.awakening.bookManagement.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = { "/", "/listBooks"})
	public String listBooks(Map<String, Object> map) {
		
		map.put("book", new Book());
		
		map.put("bookList", bookService.listBooks());
		
		return "/book/listBooks";
		
	}
	
	@RequestMapping("/get/{bookId}")
	public String getBook(@PathVariable long bookId, Map<String, Object> map) {
		
		Book book = bookService.getBook(bookId);
		
		map.put("book", book);
		
		return "book/bookForm";
		
		
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute("book") Book book, BindingResult result) {
		
		bookService.saveBook(book);
		
		return "redirect:listBooks";
		
	}
	
	@RequestMapping("delete/{bookId}")
	public String deleteBook(@PathVariable("bookId") long id) {
		
		bookService.deleBook(id);
		
		return "redirect:/book/listBooks";
		
	}
}

