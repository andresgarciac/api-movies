package co.com.movies.cassandra.repositores;

import co.com.movies.cassandra.tables.MoviesById;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface MoviesByIdRepository extends CassandraRepository<MoviesById, String> {

}
