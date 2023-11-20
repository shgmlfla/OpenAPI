package com.example.openapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UlsanRepository extends JpaRepository<Ulsan, Long> {

}
