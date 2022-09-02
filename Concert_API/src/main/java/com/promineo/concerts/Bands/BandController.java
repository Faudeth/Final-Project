package com.promineo.concerts.Bands;

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
@RequestMapping ("/concert_db/bands")
public class BandController {
  
  private BandService bandService;
  
  @Autowired
  public BandController (BandService bandService) {
    this.bandService = bandService;
  }
  
  @GetMapping
  public List <Bands> getAllBands() {
    return bandService.getAllBands();
  }
  
  @GetMapping ("{band_id}")
  public ResponseEntity <Bands> getBandById (@PathVariable ("band_id") int bandId) {
    return new ResponseEntity <Bands> (bandService.getBandByID(bandId), HttpStatus.OK);
  }
  
  @PostMapping
  public ResponseEntity <Bands> saveBand (@RequestBody Bands bands) {
    return new ResponseEntity <Bands> (bandService.saveBand(bands), HttpStatus.CREATED);
  }
  
  @PutMapping("{band_id}")
  public ResponseEntity <Bands> updateBand (@PathVariable ("band_id") int bandId, @RequestBody Bands band) {
    return new ResponseEntity <Bands> (bandService.updateBand(band, bandId), HttpStatus.OK);
  }
  
  @DeleteMapping("{band_id}")
  public ResponseEntity <String> deleteBand(@PathVariable("band_id") int bandId) {
    bandService.deleteBand(bandId);
    return new ResponseEntity<String>("Band removed.", HttpStatus.OK);
  }

}
