package com.promineo.concerts.genres;

import java.util.List;

public interface GenreService {
  
//Retrieves all genres, READ
  public List<Genres> getAllGenres();
  
//Retrieves specified genre by ID, READ  
  public Genres getGenreByID (int id);
  
//Post a genre, CREATE
  public Genres saveGenre (Genres genre);
  
//Updates a genre by ID, UPDATE  
  public Genres updateGenre (Genres genres, int id);
  
//Deletes a genre by ID, DELETE
  public void deleteGenre (int id);

}
