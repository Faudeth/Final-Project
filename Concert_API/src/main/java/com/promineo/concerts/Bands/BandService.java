package com.promineo.concerts.Bands;

import java.util.List;

public interface BandService {
  
//Retrieves all bands, READ
  public List<Bands> getAllBands();
  
//Retrieves specified band by ID, READ  
  public Bands getBandByID (int id);
  
//Post a band, CREATE
  public Bands saveBand (Bands bands);
  
//Updates a band by ID, UPDATE  
  public Bands updateBand (Bands bands, int id);
  
//Deletes a band by ID, DELETE
  public void deleteBand (int id);

}
