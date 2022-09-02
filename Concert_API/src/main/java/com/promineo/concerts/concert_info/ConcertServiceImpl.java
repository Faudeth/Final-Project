package com.promineo.concerts.concert_info;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineo.concerts.exception.ResourceNotFoundException;

@Service
public class ConcertServiceImpl implements ConcertService {
  
  private ConcertRepository concertRepository;
  
  @Autowired
  public ConcertServiceImpl (ConcertRepository concertRepository) {
    this.concertRepository = concertRepository;
  }
  
  public List<Concert> getAllConcerts() {
    return concertRepository.findAll();
  }
  
  public Concert getConcertByID (int id) {
    return concertRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Concert", "ID", id));
  }
  
  public Concert saveConcert (Concert concert) {
    return concertRepository.save(concert);
  }
  
  public Concert updateConcert (Concert concert, int id) {
    Concert existingConcert = concertRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Concert", "ID", id));
    
    existingConcert.setConcert_name (concert.getConcert_name());
    existingConcert.setTicket_price (concert.getTicket_price());
    existingConcert.setBand_id (concert.getBand_id());
    
    return existingConcert;
  }
  
  public void deleteConcert (int id) {
    Concert existingConcert = concertRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Concert", "ID", id));
    concertRepository.deleteById(id);
  }

}
