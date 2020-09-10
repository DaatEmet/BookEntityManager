package telran.ashkelon2020.book.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import telran.ashkelon2020.book.model.Book;

@Repository
public class BookRepositoryImpl implements BookRepository {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public long deleteByAuthorsName(String authorName) {
		TypedQuery<String> queryBooks = em.createQuery("select b.isbn from Book b join b.authors a where a.name=?1", String.class);
		queryBooks.setParameter(1, authorName);
		List<String> booksIsbn = queryBooks.getResultList();
		Query query = em.createQuery("delete from Book b where b.isbn in ?1");
		query.setParameter(1, booksIsbn);
		return query.executeUpdate();
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
