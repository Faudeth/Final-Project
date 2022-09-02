package com.promineo.concerts.Bands;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineo.concerts.exception.ResourceNotFoundException;

@Service
public class BandServiceImpl implements BandService {
  
  private BandRepository bandRepository;
  
  @Autowired
  public BandServiceImpl (BandRepository bandRepository) {
    this.bandRepository = bandRepository;
  }
  
  public List<Bands> getAllBands() {
    return bandRepository.findAll();
  }

  public Bands getBandByID (int id) {
    return bandRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Band", "ID", id));
  }
  
  public Bands saveBand (Bands bands) {
    return bandRepository.save(bands);
  }
  
  public Bands updateBand (Bands bands, int id) {
    Bands existingBand = bandRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Band", "ID", id));
  
    existingBand.setBand_name (bands.getBand_name());
    
    return existingBand;
  }
  
  public void deleteBand (int id) {
    Bands existingBand = bandRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Band", "ID", id));
    bandRepository.deleteById(id);
  }

}
