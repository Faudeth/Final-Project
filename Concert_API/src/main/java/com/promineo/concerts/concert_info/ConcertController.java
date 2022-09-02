package com.promineo.concerts.concert_info;

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
@RequestMapping ("/concert_db/concerts")
public class ConcertController {
  
  private ConcertService concertService;
  
  @Autowired
  public ConcertController (ConcertService concertService) {
    this.concertService = concertService;
  }
  
  @GetMapping
  public List<Concert> getAllConcerts() {
    return concertService.getAllConcerts();
  }
  
  @GetMapping ("{concert_id}")
  public ResponseEntity <Concert> getConcertById (@PathVariable ("concert_id") int concertId) {
    return new ResponseEntity <Concert> (concertService.getConcertByID(concertId), HttpStatus.OK);
  }
  
  @PostMapping
  public ResponseEntity <Concert> saveConcert (@RequestBody Concert concert) {
    return new ResponseEntity <Concert> (concertService.saveConcert(concert), HttpStatus.CREATED);
  }
  
  @PutMapping ("{concert_id}")
  public ResponseEntity <Concert> updateConcert (@PathVariable ("concert_id") int concertId, @RequestBody Concert concert) {
    return new ResponseEntity <Concert> (concertService.updateConcert(concert, concertId), HttpStatus.OK);
  }
  
  @DeleteMapping ("{concert_id}")
  public ResponseEntity <String> deleteConcert(@PathVariable("concert_id") int concertId) {
    return new ResponseEntity<String>("Concert removed.", HttpStatus.OK);
  }

}
