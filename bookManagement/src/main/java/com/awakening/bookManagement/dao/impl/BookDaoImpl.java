/**
 * 
 */
package com.awakening.bookManagement.dao.impl;

import java.util.List;

import com.awakening.bookManagement.dao.BookDao;
import com.awakening.bookManagement.model.Book;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveBook(Book book) {
		// TODO Auto-generated method stub
		getSession().merge(book);

	}

	@SuppressWarnings("unchecked")
	public List<Book> listBook() {
		// TODO Auto-generated method stub
		return getSession().createCriteria(Book.class).list();
	}

	public Book getBook(long id) {
		// TODO Auto-generated method stub
		
		return (Book)getSession().get(Book.class, id);
	}

	public void deleteBook(long id) {
		// TODO Auto-generated method stub
		Book book = getBook(id);
		
		if(book != null) {
			
			getSession().delete(book);
			
		}

	}
	
	private SessionFactory getSessionFactory() {
		
		return sessionFactory;
		
	}
	
	private Session getSession() {
		
		Session sess = getSessionFactory().getCurrentSession();
		
		if(sess == null) {
			
			sess = getSessionFactory().openSession();
			
		}
		
		return sess;
		
	}

}
