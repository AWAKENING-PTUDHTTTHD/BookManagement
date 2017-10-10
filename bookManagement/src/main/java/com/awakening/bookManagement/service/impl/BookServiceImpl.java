package com.awakening.bookManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.awakening.bookManagement.dao.BookDao;
import com.awakening.bookManagement.model.Book;
import com.awakening.bookManagement.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	
	@Transactional
	public void saveBook(Book book) {
		// TODO Auto-generated method stub
		bookDao.saveBook(book);

	}

	@Transactional(readOnly = true)
	public List<Book> listBooks() {
		// TODO Auto-generated method stub
		return bookDao.listBook();
	}

	@Transactional(readOnly = true)
	public Book getBook(long ID) {
		// TODO Auto-generated method stub
		return bookDao.getBook(ID);
	}

	@Transactional
	public void deleBook(long ID) {
		// TODO Auto-generated method stub
		
		bookDao.deleteBook(ID);

	}

}
