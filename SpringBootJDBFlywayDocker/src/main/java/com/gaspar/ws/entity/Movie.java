package com.gaspar.ws.entity;

import com.gaspar.ws.entity.Actor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor(staticName = "of")
public class Movie {
    Integer id;
    String name;
    List<Actor> actors;
    LocalDate releaseDate;
}
