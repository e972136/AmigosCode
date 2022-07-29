package com.gaspar.ws.entity;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MovieRowMaper implements RowMapper<Movie> {

    @Override
    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Movie.of(rs.getInt("id"),
                rs.getString("name"), null,
                    LocalDate.parse(rs.getString("release_date")));

    }
}
