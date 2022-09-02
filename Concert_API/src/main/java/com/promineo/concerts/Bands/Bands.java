package com.promineo.concerts.Bands;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "bands")

public class Bands {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private int band_id;
  
  @Column (name = "band_name")
  private String band_name;
  
}
