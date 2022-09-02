package com.promineo.concerts.cities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "cities")

public class Cities {
  
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private int city_id;
  
  @Column (name = "city_name")
  private String city_name;
  
  @Column (name = "state")
  private String state;
  
  @Column (name = "venue")
  private String venue;
  
  @Column (name = "concert_id")
  private int concert_id;

}
