package com.gaspar.ws.repository;

import com.gaspar.ws.entity.Movie;
import com.gaspar.ws.entity.MovieRowMaper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepositoryImp implements MovieRepository {

    private final JdbcTemplate  jdbcTemplate;

    public MovieRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Movie> selectMovies() {
        String sql ="SELECT id, name, release_date FROM movie LIMIT 100;";
        return jdbcTemplate.query(sql, new MovieRowMaper());
    }

    @Override
    public int insertMovie(Movie movie) {
        String sql = "" +
                "insert into movie(name,release_date) values(?,?);" +
                "";
        return jdbcTemplate.update(sql,movie.getName(),movie.getReleaseDate());
    }

    @Override
    public int deleteMovie(int id) {
        String sql = "" +
                "delete from movie where id=?;" +
                "";

        return  jdbcTemplate.update(sql,id);
    }

    @Override
    public Optional<Movie> selectMovieById(int id) {
        String sql ="SELECT id, name, release_date FROM movie where id = ?;";
        List<Movie> query = jdbcTemplate.query(sql, new MovieRowMaper(), id);
        return query.stream().findFirst();
    }
}
