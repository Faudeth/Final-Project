package com.promineo.concerts.cities;

import java.util.List;

public interface CityService {
  
//Retrieves all cities, READ  
  public List<Cities> getAllCities();
  
//Retrieves specified city by ID, READ  
  public Cities getCityById (int id);
  
//Post a city, CREATE  
  public Cities saveCity (Cities cities);
  
//Updates a city by ID, UPDATE    
  public Cities updateCity (Cities cities, int id);
  
//Deletes a city by ID, DELETE  
  public void deleteCity (int id);

}
