package com.promineo.concerts.concert_info;

import java.util.List;

public interface ConcertService {
  
//Retrieves all concerts, READ  
  public List<Concert> getAllConcerts();
  
//Retrieves specified concert by ID, READ    
  public Concert getConcertByID (int id);
  
//Post a concert, CREATE  
  public Concert saveConcert (Concert concert);
  
//Updates a concert by ID, UPDATE
  public Concert updateConcert (Concert concert, int id);
  
//Deletes a concert by ID, DELETE  
  public void deleteConcert (int id);

}
