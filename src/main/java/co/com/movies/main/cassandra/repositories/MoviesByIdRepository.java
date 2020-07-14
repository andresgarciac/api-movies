package co.com.movies.main.cassandra.repositories;

import co.com.movies.main.cassandra.tables.Movie;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface MoviesByIdRepository extends CassandraRepository<Movie, String> {

}
