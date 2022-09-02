package com.promineo.concerts.genres;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "genres")
public class Genres {
  
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private int genre_id;
  
  @Column (name = "genre_name")
  private String genre_name;
  
  @Column (name = "band_id")
  private int band_id;

}
