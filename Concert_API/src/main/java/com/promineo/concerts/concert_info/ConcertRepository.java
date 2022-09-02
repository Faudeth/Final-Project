package com.promineo.concerts.concert_info;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcertRepository extends JpaRepository<Concert, Integer> {

}
