package laivanvuong.dao;

import laivanvuong.entity.Book;
import java.util.List;

public interface BookDao {
	public List<Book> getAll();
	
	public Book getBookById(int id);
	
	public void saveBook(Book book);
	
	public void deleteBook(int id);
}
