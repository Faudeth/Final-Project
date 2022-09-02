package com.promineo.concerts.cities;

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
@RequestMapping ("/concert_db/cities")
public class CityController {
  
  private CityService cityService;
  
  @Autowired
  public CityController (CityService cityService) {
    this.cityService = cityService;
  }
  
  @GetMapping
  public List <Cities> getAllCities() {
    return cityService.getAllCities();
  }
  
  @GetMapping ("{city_id}")
  public ResponseEntity <Cities> getCityById (@PathVariable ("city_id") int cityId) {
    return new ResponseEntity <Cities> (cityService.getCityById(cityId), HttpStatus.OK);
  }
  
  @PostMapping
  public ResponseEntity <Cities> saveCity (@RequestBody Cities cities) {
    return new ResponseEntity <Cities> (cityService.saveCity(cities), HttpStatus.OK);
  }
  
  @PutMapping ("{city_id}")
  public ResponseEntity <Cities> updateCity (@PathVariable ("city_id") int cityId, @RequestBody Cities cities) {
    return new ResponseEntity <Cities> (cityService.updateCity(cities, cityId), HttpStatus.OK);
  }
  
  @DeleteMapping ("{city_id}")
  public ResponseEntity <String> deleteCity(@PathVariable("city_id") int cityId) {
    cityService.deleteCity(cityId);
    return new ResponseEntity <String> ("City removed.", HttpStatus.OK);
  }

}
