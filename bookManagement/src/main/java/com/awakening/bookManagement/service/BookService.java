package com.awakening.bookManagement.service;

import java.util.List;

import com.awakening.bookManagement.model.Book;

public interface BookService {
	
	// CREATE && UPDATE
	public void saveBook(Book book);
	
	// READ LIST
	public List<Book> listBooks();
	
	// GET ONE
	public Book getBook(long ID);
	
	// DELETE
	public void deleBook(long ID);

}
