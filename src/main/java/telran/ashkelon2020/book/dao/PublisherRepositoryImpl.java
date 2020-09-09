package telran.ashkelon2020.book.dao;

import java.util.Optional;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import telran.ashkelon2020.book.model.Publisher;

@Repository
public class PublisherRepositoryImpl implements PublisherRepository{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public Stream<Publisher> findDistinctByBooksAuthorsName(String name) {
		return em.createQuery("select distinct b.publisher from Book b join b.authors a where a.name=:name",
						Publisher.class)
		.setParameter("name", name)
		.getResultStream();
		
	}

	@Override
	public Optional<Publisher> findById(String publisherName) {
		return Optional.ofNullable(em.find(Publisher.class, publisherName));
	}

	@Override
	public Publisher save(Publisher publisher) {
		em.persist(publisher);
		return publisher;
	}

}
