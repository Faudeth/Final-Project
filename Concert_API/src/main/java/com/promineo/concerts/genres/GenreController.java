package com.promineo.concerts.genres;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/concert_db/genres")
public class GenreController {
  
  private GenreService genreService;
  
  @Autowired
  public GenreController (GenreService genreService) {
    this.genreService = genreService;
  }
  
  @GetMapping
  public List <Genres> getAllGenres() {
    return genreService.getAllGenres();
  }
  
  @GetMapping ("{genre_id}")
  public ResponseEntity <Genres> getGenreById (@PathVariable ("genre_id") int genreId) {
    return new ResponseEntity <Genres> (genreService.getGenreByID(genreId), HttpStatus.OK);
  }
  
  @PostMapping
  public ResponseEntity <Genres> saveGenre (@RequestBody Genres genres) {
    return new ResponseEntity <Genres> (genreService.saveGenre(genres), HttpStatus.CREATED);
  }
  
  @PutMapping ("{genre_id}")
  public ResponseEntity <Genres> updateGenre (@PathVariable ("genre_id") int genreId,@RequestBody Genres genres) {
    return new ResponseEntity <Genres> (genreService.updateGenre(genres, genreId), HttpStatus.OK);
  }
  
  @DeleteMapping("{genre_id}")
  public ResponseEntity <String> deleteGenre(@PathVariable("genre_id") int genreId) {
    genreService.deleteGenre(genreId);
    return new ResponseEntity<String>("Genre removed.", HttpStatus.OK);
  }

}
