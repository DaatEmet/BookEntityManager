package telran.ashkelon2020.book.dao;

import java.util.Optional;

import telran.ashkelon2020.book.model.Book;

public interface BookRepository{
	
	long deleteByAuthorsName(String authorName);

	boolean existsById(String isbn);
	
	Book save(Book book);
	
	Optional<Book> findById(String id);

	void delete(Book book);
}
