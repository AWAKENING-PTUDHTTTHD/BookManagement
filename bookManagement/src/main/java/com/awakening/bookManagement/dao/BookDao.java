package com.awakening.bookManagement.dao;

import java.util.List;

import com.awakening.bookManagement.model.Book;

public interface BookDao {
	
	/* CREATE && UPDATE */
	public void saveBook(Book book);
	
	/* GET LIST */
	public List<Book> listBook();
	
	/* Find One By ID */
	public Book getBook(long id);
	
	/* DELETE */
	public void deleteBook(long id);
	
	

}
