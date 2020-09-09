package telran.ashkelon2020.book.dao;

import java.util.Optional;
import java.util.stream.Stream;

import telran.ashkelon2020.book.model.Publisher;

public interface PublisherRepository {

	Stream<Publisher> findDistinctByBooksAuthorsName(String authorName);

	Optional<Publisher> findById(String publisherName);

	Publisher save(Publisher publisher);
}
