package com.promineo.concerts.genres;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineo.concerts.exception.ResourceNotFoundException;

@Service
public class GenreServiceImpl implements GenreService {
  
  private GenreRepository genreRepository;
  
  @Autowired
  public GenreServiceImpl (GenreRepository genreRepository) {
    this.genreRepository = genreRepository;
  }
  
  public List<Genres> getAllGenres() {
    return genreRepository.findAll();
  }

  public Genres getGenreByID (int id) {
    return genreRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Genre", "ID", id));
  }
  
  public Genres saveGenre (Genres genres) {
    return genreRepository.save(genres);
  }
  
  public Genres updateGenre (Genres genres, int id) {
    Genres existingGenre = genreRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Genre", "ID", id));
  
    existingGenre.setGenre_name (genres.getGenre_name());
    existingGenre.setBand_id(genres.getBand_id());
    
    return existingGenre;
  }
  
  public void deleteGenre (int id) {
    Genres existingGenre = genreRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Genre", "ID", id));
    genreRepository.deleteById(id);
  }

}
