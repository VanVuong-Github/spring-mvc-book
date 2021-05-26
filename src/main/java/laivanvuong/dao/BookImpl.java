package laivanvuong.dao;

import laivanvuong.entity.Book;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BookImpl implements BookDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Book> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Book> list = session.createQuery("from Book", Book.class).getResultList();
		return list;
	}
	
	@Transactional
	public Book getBookById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Book book = session.find(Book.class, id);
		return book;
	}
	
	@Transactional
	public void saveBook(Book book) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(book);
		
	}
	
	@Transactional
	public void deleteBook(int id) {
		Session session = sessionFactory.getCurrentSession();
		Book book = session.find(Book.class, id);
		if(book != null) {
			session.delete(book);
		}
	}

}
