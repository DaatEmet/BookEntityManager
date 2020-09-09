package telran.ashkelon2020.book.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import telran.ashkelon2020.book.model.Book;

@Repository
public class BookRepositoryImpl implements BookRepository {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public long deleteByAuthorsName(String authorName) {
		return em.createQuery("select b from Book b join b.authors a where a.name = ?1")
				.setParameter(1, authorName)
				.getResultList().size();
		
	}


	@Override
	public boolean existsById(String isbn) {
		return em.find(Book.class, isbn) != null;
	}

	@Override
	public Book save(Book book) {
		em.persist(book);
		return book;
	}

	@Override
	public Optional<Book> findById(String id) {
		return Optional.ofNullable(em.find(Book.class, id));
	}

	@Override
	public void delete(Book book) {
		em.remove(book);
	}

}
