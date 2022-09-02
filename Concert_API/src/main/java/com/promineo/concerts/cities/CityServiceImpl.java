package com.promineo.concerts.cities;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineo.concerts.exception.ResourceNotFoundException;

@Service
public class CityServiceImpl implements CityService {
  
  private CityRepository cityRepository;
  
  @Autowired
  public CityServiceImpl (CityRepository cityRepository) {
    this.cityRepository = cityRepository;
  }
  
  public List<Cities> getAllCities() {
    return cityRepository.findAll();
  }
  
  public Cities getCityById (int id) {
    return cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("City", "ID", id));
  }
  
  public Cities saveCity (Cities cities) {
    return cityRepository.save(cities);
  }
  
  public Cities updateCity (Cities cities, int id) {
    Cities existingCity = cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("City", "ID", id));
    
    existingCity.setCity_name (cities.getCity_name());
    existingCity.setState (cities.getState());
    existingCity.setVenue (cities.getVenue());
    existingCity.setConcert_id (cities.getConcert_id());
    
    return existingCity;
  }
  
  public void deleteCity (int id) {
    Cities existingCity = cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("City", "ID", id));
    cityRepository.deleteById(id);
  }

}
