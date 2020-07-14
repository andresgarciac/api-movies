package co.com.movies.main.cassandra.tables;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(Movie.MOVIES_BY_ID_TABLE)
public class Movie {

    static final String MOVIES_BY_ID_TABLE = "movies_by_id_table";

    public static String creteTableStatement(String keyspace) {
        return String.format("CREATE TABLE IF NOT EXISTS "
                + "%s.%s("
                + " movie_id text,"
                + " genre text,"
                + " name text,"
                + " synopsis text,"
                + " creation_date timestamp,"
                + " director text,"
                + " PRIMARY KEY (movie_id)"
                + ");",
        keyspace, MOVIES_BY_ID_TABLE);
    }

    @PrimaryKey
    @Column("movie_id")
    private String movieId;

    @Column("genre")
    private String genre;

    @Column("name")
    private String name;

    @Column("synopsis")
    private String synopsis;

    @Column("creation_date")
    private Date creationDate;

    @Column("director")
    private String director;
}
