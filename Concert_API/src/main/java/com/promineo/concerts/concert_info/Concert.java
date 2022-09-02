package com.promineo.concerts.concert_info;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "concerts")
public class Concert {
  
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private int concert_id;
  
  @Column (name = "concert_name")
  private String concert_name;
  
  @Column (name = "ticket_price")
  private BigDecimal ticket_price;
  
  @Column (name = "band_id")
  private int band_id;

}
